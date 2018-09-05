# GoogleAnalyticsLib

Usage

- Step 1. Add the JitPack repository to your build file

allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
- Step 2. Add the dependency

dependencies {
    compile 'com.github.Victor2018:GoogleAnalyticsLib:latestVersion'
}

- Step 3. Add google gms lib in build.gradle of app  and sync project
   //gms
   implementation 'com.google.android.gms:play-services-analytics:15.0.0'

- Step 4. add you trackingId in AndroidManifest.xml

  <meta-data android:name="GA_TRACKING_ID" android:value="${YOUR_TRACKING_ID}"/>

- Step 5. AnalyticsHelper.getInstance().init(this);

- Step 6. you can send customAction or screenName by this:

   AnalyticsHelper.getInstance().sendCustomAction(category,action,lable,value);
   AnalyticsHelper.getInstance().sendScreenName(screenName);

- Step 7. you can see the analytics datas by this url:

  https://analytics.google.com/analytics/web/?hl=zh&authuser=0#/report-home/a125179676w183709909p181191671

  ![image](https://github.com/Victor2018/GoogleAnalyticsLib/raw/master/SrceenShot/custom_action.png)

  ![image](https://github.com/Victor2018/GoogleAnalyticsLib/raw/master/SrceenShot/screen_name.png)



## Reference material ：

https://developers.google.com/analytics/devguides/collection/android/v4/?hl=zh-cn

## Focus on developer

- E-mail: victor423099@gmail.com
- Sina Weibo
- ![image](https://github.com/Victor2018/AppUpdateLib/raw/master/SrceenShot/sina_weibo.jpg)

## License

Copyright (c) 2018 Victor

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.