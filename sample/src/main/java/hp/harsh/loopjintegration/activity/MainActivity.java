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

package hp.harsh.loopjintegration.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import hp.harsh.library.interfaces.LoopjInterface;
import hp.harsh.library.loopj.LoopjRequest;
import hp.harsh.loopjintegration.R;
import hp.harsh.loopjintegration.utilbag.ApiManager;
import hp.harsh.loopjintegration.utilbag.CommonUtil;
import hp.harsh.loopjintegration.utilbag.RequestParams;

public class MainActivity extends AppCompatActivity implements LoopjInterface {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* Call API using below method
        *
        * new LoopjRequest(Activity activity,
        *       Method requestType,
        *       String url,
        *       Map<String, String> params,
        *       Map<String, String> headers,
        *       int uniqueId,
        *       boolean isShowDialog,
        *       LoopjInterface objInterface);
        * */
    }

    // Call API using GET method
    public void callLoopjGetApi(View view) {
        // Check internet connection
        if (!CommonUtil.isInternetAvailable(MainActivity.this)) {
            return;
        }

        // Make Loopj request
        new LoopjRequest(MainActivity.this,

                LoopjRequest.Method.GET, // Add request method

                ApiManager.CHECK_LOOPJ_WITH_GET, // Add API URL to call

                RequestParams.testBody("Harsh", "harsh@test.com"), // Add body parameter. If there is no body, use null

                RequestParams.getNull(), // Add header. If there is no header, use null

                ApiManager.ID_CHECK_LOOPJ_WITH_GET, // Add unique id for each API to differentiate

                true, // boolean for isProgress bar require or not

                this); // Loopj interface
    }

    // Call API using POST method
    public void callLoopjPostApi(View view) {
        // Check internet connection
        if (!CommonUtil.isInternetAvailable(MainActivity.this)) {
            return;
        }

        // Make Loopj request
        new LoopjRequest(MainActivity.this,
                LoopjRequest.Method.POST,  // Add request method
                ApiManager.CHECK_LOOPJ_WITH_POST, // Add API to call
                RequestParams.testBody("Harsh", "harsh_test@gmail.com"), // Add body parameter. If there is no body, use null
                RequestParams.getNull(), // Add header. If there is no header, use null
                ApiManager.ID_CHECK_LOOPJ_WITH_POST, // Add unique id for each API to differentiate
                true, // boolean for isProgress bar require or not
                this); // Loopj interface
    }

    // Call API using POST method with header
    public void callLoopjPostApiWithHeader(View view) {
        // Check internet connection
        if (!CommonUtil.isInternetAvailable(MainActivity.this)) {
            return;
        }

        // Make Loopj request
        new LoopjRequest(MainActivity.this,
                LoopjRequest.Method.POST, // Add request method
                ApiManager.CHECK_LOOPJ_WITH_POST_HEADER, // Add API to call
                RequestParams.testBody("Harsh", "harsh_test@gmail.com"), // Add body parameter. If there is no body, use null
                RequestParams.defaultHeader(), // Add header. If there is no header, use null
                ApiManager.ID_CHECK_LOOPJ_WITH_POST_HEADER, // Add unique id for each API to differentiate
                true, // boolean for isProgress bar require or not
                this); // Loopj interface
    }

    @Override
    public void onLoopjStart(int requestId) {

        // Notify when API request start and differentiate using unique Id
        switch (requestId) {
            case ApiManager.ID_CHECK_LOOPJ_WITH_GET:
                Log.i(TAG, "onLoopjStart -> start");
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST:
                Log.i(TAG, "onLoopjStart -> start");
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST_HEADER:
                Log.i(TAG, "onLoopjStart -> start");
                break;
        }
    }

    @Override
    public void onLoopjSuccess(int requestId, int statusCode, byte[] bytes) {

        // Receive API response in bytes. Check whether it is null or not
        String response = "";
        if (bytes != null) {
            response = "null";
        } else {
            response = new String(bytes);
        }

        // Differentiate API response using unique Id
        switch (requestId) {
            case ApiManager.ID_CHECK_LOOPJ_WITH_GET:
                Log.i(TAG, "onLoopjSuccess -> " + response);
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST:
                Log.i(TAG, "onLoopjSuccess -> " + response);
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST_HEADER:
                Log.i(TAG, "onLoopjSuccess -> " + response);
                break;
        }
    }

    @Override
    public void onLoopjFailure(int requestId, int statusCode, byte[] bytes, Throwable error) {

        // Receive API response in bytes. Check whether it is null or not
        String response = "";
        if (bytes != null) {
            response = "null";
        } else {
            response = new String(bytes);
        }

        // Differentiate API response using unique Id
        switch (requestId) {
            case ApiManager.ID_CHECK_LOOPJ_WITH_GET:
                Log.e(TAG, "onLoopjFailure -> " + response);
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST:
                Log.i(TAG, "onLoopjFailure -> " + response);
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST_HEADER:
                Log.i(TAG, "onLoopjFailure -> " + response);
                break;
        }
    }

    @Override
    public void onLoopjFinish(int requestId) {

        // Notify when API request finish and differentiate using unique Id
        switch (requestId) {
            case ApiManager.ID_CHECK_LOOPJ_WITH_GET:
                Log.i(TAG, "onLoopjFinish -> true");
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST:
                Log.i(TAG, "onLoopjFinish -> true");
                break;
            case ApiManager.ID_CHECK_LOOPJ_WITH_POST_HEADER:
                Log.i(TAG, "onLoopjFinish -> true");
                break;
        }
    }
}
