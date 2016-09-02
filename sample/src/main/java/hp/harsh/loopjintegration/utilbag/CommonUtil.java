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

package hp.harsh.loopjintegration.utilbag;

import android.content.Context;
import android.widget.Toast;

import hp.harsh.loopjintegration.R;

/**
 * Created by Harsh Patel on 9/1/2016.
 */
public class CommonUtil {

    // Check Internet connection
    public static boolean isInternetAvailable(Context context) {
        ConnectionDetector cd = new ConnectionDetector(context);
        Boolean isInternetPresent = cd.isConnectingToInternet();

        if (!isInternetPresent) {
            Toast.makeText(context, context.getResources().getString(R.string.toast_no_internet), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return isInternetPresent;
        }
    }

}
