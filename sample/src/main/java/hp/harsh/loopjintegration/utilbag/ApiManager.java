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

/**
 * Created by Harsh Patel on 9/1/2016.
 */
public class ApiManager {

    // Base URL
    public static String BASE_URL = "http://example.loopj/api/";

    // Custom api URL
    public static String CHECK_LOOPJ_WITH_GET = BASE_URL + "getTest";
    public static String CHECK_LOOPJ_WITH_POST = BASE_URL + "postTest";
    public static String CHECK_LOOPJ_WITH_POST_HEADER = BASE_URL + "postHeaderTest";

    // Custom api URL id
    public static final int ID_CHECK_LOOPJ_WITH_GET = 1;
    public static final int ID_CHECK_LOOPJ_WITH_POST = 2;
    public static final int ID_CHECK_LOOPJ_WITH_POST_HEADER = 3;

}
