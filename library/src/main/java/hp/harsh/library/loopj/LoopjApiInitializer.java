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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Map;

/**
 * Created by Harsh Patel on 9/1/2016.
 */
public class LoopjApiInitializer {

    private static AsyncHttpClient client;

    public static void get(String url, RequestParams params, Map<String, String> headers, AsyncHttpResponseHandler responseHandler) {
        callLoopjClient(headers).get(url, params, responseHandler);
    }

    public static void post(String url, RequestParams params, Map<String, String> headers, AsyncHttpResponseHandler responseHandler) {
        callLoopjClient(headers).post(url, params, responseHandler);
    }

    public static void delete(String url, RequestParams params, Map<String, String> headers, AsyncHttpResponseHandler responseHandler) {
        callLoopjClient(headers).delete(url, params, responseHandler);
    }

    // Add header if existed
    public static AsyncHttpClient callLoopjClient(Map<String, String> headers) {
        client = new AsyncHttpClient();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                client.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return client;
    }
}
