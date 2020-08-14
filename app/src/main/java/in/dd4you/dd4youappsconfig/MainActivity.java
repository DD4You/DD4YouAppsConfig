package in.dd4you.dd4youappsconfig;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import in.dd4you.appsconfig.DD4YouConfig;
import in.dd4you.appsconfig.DD4YouNetReceiver;
import in.dd4you.appsconfig.DDPreferenceManager;

public class MainActivity extends AppCompatActivity {

    private DD4YouNetReceiver dd4YouNetReceiver;
    private DD4YouConfig dd4YouConfig;
    private DDPreferenceManager preferenceManager;

    private ViewGroup myRootView;

    private Button check_sdcard, check_app_folder, create_app_folder, check_password, set_password, match_password;
    private Button delete_password, more_apps, rate_us, share_app, follow_on_insta, contact_by_whatsapp, contact_by_email;
    private Button share_on_whatsapp, share_on_whatsapp_business, subscribe_on_yt, watch_on_yt, check_internet_btn, check_update_btn;
    private Button share_with_image, rate_us_dialog, exit_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dd4YouConfig = new DD4YouConfig(this);
        preferenceManager = new DDPreferenceManager(this, "dd4you");
        //  DD4YouConfig.init(this);
        // Get Root View Current Activity
        myRootView = findViewById(R.id.myRootView);

        registerBroadcastReceiver();

        TextView textView = findViewById(R.id.textView);
        check_sdcard = findViewById(R.id.check_sdcard);
        check_app_folder = findViewById(R.id.check_app_folder);
        create_app_folder = findViewById(R.id.create_app_folder);
        check_password = findViewById(R.id.check_password);
        set_password = findViewById(R.id.set_password);
        match_password = findViewById(R.id.match_password);
        delete_password = findViewById(R.id.delete_password);
        more_apps = findViewById(R.id.more_apps);
        rate_us = findViewById(R.id.rate_us);
        share_app = findViewById(R.id.share_app);
        follow_on_insta = findViewById(R.id.follow_on_insta);
        contact_by_whatsapp = findViewById(R.id.contact_by_whatsapp);
        contact_by_email = findViewById(R.id.contact_by_email);
        share_on_whatsapp = findViewById(R.id.share_on_whatsapp);
        share_on_whatsapp_business = findViewById(R.id.share_on_whatsapp_business);
        subscribe_on_yt = findViewById(R.id.subscribe_on_yt);
        watch_on_yt = findViewById(R.id.watch_on_yt);
        check_internet_btn = findViewById(R.id.check_internet_btn);
        check_update_btn = findViewById(R.id.check_update_btn);
        share_with_image = findViewById(R.id.share_with_image);
        rate_us_dialog = findViewById(R.id.rate_us_dialog);
        exit_dialog = findViewById(R.id.exit_dialog);

        check_sdcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.isSDCardPresent()) {
                    showToast("Exist.");
                }else {
                    showToast("Not Exist.");
                }
            }
        });

        check_app_folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.isApkFolder("Test")) {
                    showToast("Exist.");
                } else {
                    showToast("Not Exist.");
                }
            }
        });

        create_app_folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.createApkFolder("Test")){
                    showToast("Success");
                }else {
                    showToast("Fail.");
                }
            }
        });

        check_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.isPassword()){
                    showToast("Exist");
                }else {
                    showToast("Not Exist.");
                }
            }
        });

        set_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.setPassword("123")){
                    showToast("Success");
                }else {
                    showToast("Fail.");
                }
            }
        });

        match_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.verifyPassword("123")){
                    showToast("Match");
                }else {
                    showToast("Not Match.");
                }
            }
        });

        delete_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.removePassword()){
                    showToast("Success");
                }else {
                    showToast("Fail.");
                }
            }
        });

        more_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.moreApps("DD4You");
            }
        });
        rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.rateUs();
            }
        });
        share_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.shareApp("Share Text here");
            }
        });

        follow_on_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.followOnInstagram("_dd4you");
            }
        });
        contact_by_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.contactByWhatsApp("917007916170","Message here");
            }
        });
        contact_by_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.contactByEmail("info@dd4you.in","","");
            }
        });

        share_on_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.shareOnWhatsApp("message here");
            }
        });

        share_on_whatsapp_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.shareOnWhatsAppBusiness("message here");
            }
        });
        subscribe_on_yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.subscribeOnYoutube("DD4You");
            }
        });
        watch_on_yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.watchOnYoutube("FWE8IAQa9N8");
            }
        });

        check_internet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dd4YouConfig.isInternetConnectivity()) {
                    Toast.makeText(MainActivity.this, "Internet on", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Internet off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        check_update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dd4YouConfig.checkAppUpdate();
                dd4YouConfig.devInfo();
            }
        });

        share_with_image.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dev_image_bg);
                dd4YouConfig.shareWithImage("Write your message...", bitmap);
                //  DD4YouConfig.shareWithImage("testimage", "Share with image test", bitmap); // you can pass image name also
            }
        });

        rate_us_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.rateUsDialog("Write title here...", "Write message here...");
            }
        });

        exit_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd4YouConfig.appExitDialog(R.drawable.ic_launcher_foreground,"Exit From App");
            }
        });


        String test = "Device Version: " + dd4YouConfig.getDeviceVersion()+
                "\nApp Version Code: " + dd4YouConfig.getAppVersionCode()+
                "\nCurrent Time Stamp: " + dd4YouConfig.getCurrentTimestamp()+
                "\nDevice Manufacturer: " + dd4YouConfig.getDeviceManufacturer()+
                "\nDevice Model: " + dd4YouConfig.getDeviceModel()+
                "\nPhone User: " + dd4YouConfig.getPhoneUser()+
                "\nDevice ID: " + dd4YouConfig.getDeviceId()+
                "\nBrand: " + dd4YouConfig.getBrand() +
                "\nType: " + dd4YouConfig.getType() +
                "\nHost: " + dd4YouConfig.getHost() +
                "\nProduct: " + dd4YouConfig.getProduct() +
                "\nAndroid Version: " + dd4YouConfig.getAndroidVersion() +
                "\nApp Version Name: " + dd4YouConfig.getAppVersionName() +
                "\nCurrent Date: " + dd4YouConfig.getCurrentDate(DD4YouConfig.Constant.TimestampFormat7) +
                "\nCurrent Time: " + dd4YouConfig.getCurrentTime("hh:mm a") +
                "\nString: abcd12345"+
                "\nGet Start: "+ dd4YouConfig.getFromStartString("abcd12345",3)+
                "\nGet End: "+ dd4YouConfig.getFromEndString("abcd12345",4)+
                "\nRemove End: "+ dd4YouConfig.removeFromEnd("abcd12345",2)+
                "\nRemove Start: "+ dd4YouConfig.removeFromStart("abcd12345", 3)+
                "\nRemove Both: "+ dd4YouConfig.removeFromBothSide("abcd12345",2,1)+
                "\nRandom String: " + dd4YouConfig.generateRandomString(10).toUpperCase()+
                "\nUnique ID: " + dd4YouConfig.generateUniqueID(9).toUpperCase()+
                "\nMd5: "+ dd4YouConfig.encryptToMd5("123")+
                "\nSHA-1: "+ dd4YouConfig.encryptToSHA1("123")+
                "\nSHA-224: "+ dd4YouConfig.encryptToSHA224("123")+
                "\nSHA-256: "+ dd4YouConfig.encryptToSHA256("123")+
                "\nSHA-384: "+ dd4YouConfig.encryptToSHA384("123")+
                "\nSHA-512: "+ dd4YouConfig.encryptToSHA512("123")+
                "\nTime ago Unix: "+ dd4YouConfig.getTimeAgo("1594222229")+
                "\nGet Format Date: "+ dd4YouConfig.getDateTime("1594222229", DD4YouConfig.Constant.DateTimeFormat2, true)+
                "\nGet Format Date: "+ dd4YouConfig.getDateTime("2020-08-13 05:18:20", DD4YouConfig.Constant.DateTimeFormat2, false)+
                "\nTime ago: "+ dd4YouConfig.getTimeAgo("2020-08-13 05:18:20", DD4YouConfig.Constant.TimestampFormat1, false)+
                "\nRandom Digits: "+ dd4YouConfig.generateRandomDigits()+
                "\nDD4You Number Format: " + dd4YouConfig.dd4youNumberFormat(1400);
        textView.setText(test);
        dd4YouConfig.checkInAppUpdate(DD4YouConfig.Constant.UPDATE_FLEXIBLE );

        preferenceManager.putBoolean("boolean", true);
        preferenceManager.putFloat("float", (float) 21.00);
        preferenceManager.putInt("int", 2);
        preferenceManager.putLong("long", 4);
        preferenceManager.putString("string", "it's work");

        Set<String> hash_Set = new HashSet<>();
        hash_Set.add("Vinay");
        hash_Set.add("Singh");
        hash_Set.add("DD4You");

        preferenceManager.putStringSet("stringSet", hash_Set);

       // Log.d("TEST_APP", preferenceManager.getAllPreferences().toString());
    }

    private void registerBroadcastReceiver() {
        if (dd4YouNetReceiver == null)
            dd4YouNetReceiver = new DD4YouNetReceiver(myRootView,1000);
        dd4YouNetReceiver.register(this.getApplicationContext());
    }
    private void unregisterBroadcastReceiver() {
        if (dd4YouNetReceiver != null)
        {
            dd4YouNetReceiver.unregister(this.getApplicationContext());
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterBroadcastReceiver();
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcastReceiver();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterBroadcastReceiver();
    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
