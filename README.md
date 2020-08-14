# DD4YouAppsConfig
Very usefull more than 36 methods for you. you can use all methodes single line of code


## Installation
DD4YouAppsConfig is installed by adding the following dependency to your build.gradle(app) file:
<pre>
dependencies {  
      implementation 'in.dd4you.appsconfig:appsconfig:1.3.5'  
}
</pre>

## Constant Values version 1.3.3
UPDATE_REQUEST_CODE  
UPDATE_FLEXIBLE  
UPDATE_IMMEDIATE  
TimestampFormat1 - TimestampFormat8  
DateFormat1 - DateFormat5  
TimeFormat1 - TimeFormat4  
DateTimeFormat1 - DateTimeFormat4  

#How to use
<pre>
use any method or constant values by creating object Like below

private DD4YouConfig dd4YouConfig;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dd4YouConfig = new DD4YouConfig(this);
   }
   
Use any method like below
dd4YouConfig.methodName();

Use any constant like below

DD4YouConfig.Constant.TimestampFormat1

you can use DDPreferenceManager class
</pre>

## int methods
**.getDeviceVersion()**  
**.getAppVersionCode()**  
**.generateRandomDigits()**  version 1.2.3  

## long methods
**.getCurrentTimestamp()**

## String methods
**.getDeviceManufacturer()**  
**.getDeviceModel()**  
**.getPhoneUser()**  
**.getDeviceId()**  
**.getBrand()**  
**.getType()**  
**.getHost()**  
**.getProduct()**  
**.getAndroidVersion()**  
**.getAppVersionName()**  
**.getCurrentDate()**  
**.getCurrentTime()**  
**.removeFromEnd()**  new  
**.removeFromStart()**  new  
**.removeFromBothSide()**  new  
**.getFromStartString()** new  
**.getFromEndString()** new  
**.generateRandomString()**  new  
**.generateUniqueID()**  new  
**.encryptToMd5()**  new  
**.encryptToSHA1()**  new  
**.encryptToSHA224()**  new  
**.encryptToSHA256()**  new  
**.encryptToSHA384()**  new  
**.encryptToSHA512()**  new  
**.dd4youNumberFormat()** version 1.2.3  
**.getTimeAgo()**  version 1.2.3 Support Only Unix Timestamp  
**.getTimeAgo()**  version 1.3.3 Support All Timestamp  

## boolean methods
**.isSDCardPresent()**  
**.isApkFolder()**  
**.createApkFolder()**  
**.isPassword()**  
**.setPassword()**  
**.verifyPassword()**  
**.removePassword()**  
**.isInternetConnectivity()** new  

## void methods
**.moreApps()**  
**.rateUs()**  
**.rateUsDialog()**  version 1.3.3  
**.shareApp()**  
**.followOnInstagram()**  
**.contactByWhatsApp()**  
**.contactByEmail()**  
**.shareOnWhatsApp()**  
**.shareOnWhatsAppBusiness()**  
**.subscribeOnYoutube()**  
**.watchOnYoutube()**  
**.checkAppUpdate()**  remove in version 1.3.5  
**.checkInAppUpdate()**  version 1.3.3  
**.shareWithImage()**  version 1.2.3  
**.appExitDialog()**  version 1.3.5  
**.getDateTime()**  version 1.3.5


## Date Format List
MM  = Month example 03  
dd  = Day example 31  
yyyy  = Year example 2020  
hh  = hours example 10  
mm = minutes  example 30  
ss = seconds  example 20  
a = am/pm example 11 am or 10 pm  

**Some Example on Date & Time Format**
06:51 = hh:mm  
06:51:00 = hh:mm:ss  
06:51 am or 06:51 pm = hh:mm a  
06:51:00 am or 06:51:00 pm = hh:mm:ss a  

31-03-2020  = dd-MM-yyyy  
03-31-2020  = MM-dd-yyyy  
2020-03-31  = yyyy-MM-dd  


# LICENSE
<pre>
	          Copyright 2020 DD4You.in  
            
   Licensed under the Apache License, Version 2.0 (the "License");  
   you may not use this file except in compliance with the License.  
   You may obtain a copy of the License at  

     http://www.apache.org/licenses/LICENSE-2.0  

   Unless required by applicable law or agreed to in writing, software  
   distributed under the License is distributed on an "AS IS" BASIS,  
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
   See the License for the specific language governing permissions and  
   limitations under the License.
</pre>
