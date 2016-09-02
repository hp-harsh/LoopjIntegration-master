/*
* Copyright 2016 Harsh Patel
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package hp.harsh.library.loopj;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import hp.harsh.library.interfaces.LoopjInterface;

/**
 * Created by Harsh Patel on 9/1/2016.
 */
public class LoopjRequest {

    private static final String TAG = "LoopjRequest";
    private String mUrl = "";
    private ProgressDialog mProgressDialog;
    private Activity mActivity;
    private Map<String, String> mParams = new HashMap<String, String>();
    private Map<String, String> mHeaders = new HashMap<String, String>();
    private boolean mIsShowProgressDialog;
    private int mRequestId;
    private Method mRequestType;
    private LoopjInterface mObjInterface;

    // Get all requested parameter and initiate API call
    public LoopjRequest(Activity activity, Method requestType, String url, Map<String, String> params, Map<String, String> headers, int type, boolean isShowDialog, LoopjInterface objInterface) {
        this.mActivity = activity;
        this.mRequestType = requestType;
        this.mParams = params;
        this.mHeaders = headers;
        this.mIsShowProgressDialog = isShowDialog;
        this.mRequestId = type;
        this.mObjInterface = objInterface;
        mUrl = url;

        // Call API Request
        callWebApiRequest();
    }

    private synchronized void callWebApiRequest() {
        // Request parameter
        RequestParams requestParams = new RequestParams(mParams);

        // Response handler
        AsyncHttpResponseHandler asyncHttpResponseHandler = new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                showProgress();
                mObjInterface.onLoopjStart(mRequestId);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                mObjInterface.onLoopjSuccess(mRequestId, statusCode, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] response, Throwable error) {
                mObjInterface.onLoopjFailure(mRequestId,statusCode, response, error);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                dismissProgress();
                mObjInterface.onLoopjFinish(mRequestId);
            }
        };

        // Request Method
        switch (mRequestType) {
            case GET:
                Log.e(TAG, "URL==>" + mUrl);
                LoopjApiInitializer.get(mUrl, requestParams, mHeaders, asyncHttpResponseHandler);
                break;
            case POST:
                Log.e(TAG, "URL==>" + mUrl);
                LoopjApiInitializer.post(mUrl, requestParams, mHeaders, asyncHttpResponseHandler);
                break;
            case DELETE:
                Log.e(TAG, "URL==>" + mUrl);
                LoopjApiInitializer.delete(mUrl, requestParams, mHeaders, asyncHttpResponseHandler);
                break;
            default:
                break;
        }
    }

    // Show progress
    private void showProgress() {
        if (mIsShowProgressDialog) {
            mProgressDialog = getProgressDialog(mActivity);
        }
    }

    // Dismiss progress
    private void dismissProgress() {
        if (mIsShowProgressDialog) {
            mProgressDialog.dismiss();
        }
    }

    private ProgressDialog getProgressDialog(Context c) {
        ProgressDialog pDialog = new ProgressDialog(c);
        pDialog.setMessage("Please wait..");
        pDialog.setCancelable(false);
        pDialog.show();
        return pDialog;
    }

    // Request method
    public enum Method {
        POST, GET, DELETE
    }

}
