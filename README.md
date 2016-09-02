# LoopjIntegration-master

LoopjIntegration allows to call APIs using Loopj-android-async-http

This simple and fast library to call APIs.

## How to use

Here is some simple step to follow.

#### 1. Implement Interface

For example,

```sh
public class MainActivity extends AppCompatActivity implements LoopjInterface
```

or

```sh
public class MainFragment extends Fragment implements LoopjInterface
```

#### 2. API Call Request

Add all require parameters in LoopjRequest() as mentioned below and it start process itself.

```sh
new LoopjRequest(Activity activity,
               Method requestType,
               String url,
               Map<String, String> params,
               Map<String, String> headers,
               int uniqueId,
               boolean isShowDialog,
               LoopjInterface objInterface);
```
               
For example,

```sh
new LoopjRequest(MainActivity.this,
                        LoopjRequest.Method.GET,    // Add request method
                
                        ApiManager.CHECK_LOOPJ_WITH_GET,    // Add API to call
                
                        RequestParams.testBody("Harsh", "harsh@test.com"),  // Add body parameter. If there is no body, use null
                
                        RequestParams.getNull(),    // Add header. If there is no header, use null
                
                        ApiManager.ID_CHECK_LOOPJ_WITH_GET,     // Add unique id for each API to differentiate
                
                        true,   // boolean for isProgress bar require or not
                
                        this);  // Loopj interface
```

#### 3. Getting response from API

When API call Strat, Success, Failure and Finish, it notify in onLoopjStart, onLoopjSuccess, onLoopjFailure and onLoopjFinish accordingly.

```sh
    @Override
    public void onLoopjStart(int requestId) {
        // Notify when API request start.
    }

    @Override
    public void onLoopjSuccess(int requestId, int statusCode, byte[] bytes) {
        // Receive API response in bytes.
    }
    
    public void onLoopjFailure(int requestId, int statusCode, byte[] bytes, Throwable error) {
        // Receive API response in bytes.
    }

    @Override
    public void onLoopjFinish(int requestId) {
        // Notify when API request finish.
    }
```

## Download

To integrate it into your project, add library to your project and include following in your project build.gradle file

```sh
dependencies {
    compile project(':library')
}
```

## Licence

Copyright 2016 Harsh Patel

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
