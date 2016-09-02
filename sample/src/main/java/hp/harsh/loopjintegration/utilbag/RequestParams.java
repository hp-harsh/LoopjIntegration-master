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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Harsh Patel on 9/1/2016.
 */
public class RequestParams {

    // Use for null parameter
    public static Map<String, String> getNull() {
        Map<String, String> mParam = new HashMap<String, String>();
        return mParam;
    }

    // Default header in my case
    public static Map<String, String> defaultHeader() {
        Map<String, String> map = new HashMap<>();
        //map.put("Content-Type", "application/json; charset=utf-8");
        map.put("LANG", "en");
        map.put("OS", "android");
        return map;
    }

    // Body parameter
    public static Map<String, String> testBody(String name, String email) {
        Map<String, String> map = new HashMap<>();
        map.put("username", "" + name);
        map.put("password", "" + email);
        return map;
    }

}
