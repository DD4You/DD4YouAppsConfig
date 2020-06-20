package in.dd4you.dd4youappsconfig;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import in.dd4you.appsconfig.DD4YouConfig;
import in.dd4you.appsconfig.DD4YouNetReceiver;

public class MainActivity extends AppCompatActivity {

    private DD4YouConfig dd4YouConfig;
    private DD4YouNetReceiver dd4YouNetReceiver;
    private ViewGroup myRootView;


    private Button check_sdcard, check_app_folder, create_app_folder, check_password, set_password, match_password;
    private Button delete_password, more_apps, rate_us, share_app, follow_on_insta, contact_by_whatsapp, contact_by_email;
    private Button share_on_whatsapp, share_on_whatsapp_business, subscribe_on_yt, watch_on_yt, check_internet_btn, check_update_btn;
    private Button share_with_image;

    private ImageView test_image;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dd4YouConfig = new DD4YouConfig(this);
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

        test_image = findViewById(R.id.test_image);

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
                dd4YouConfig.shareApp("Share  Text here");
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
               dd4YouConfig.checkAppUpdate();
            }
        });

        share_with_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable)test_image.getDrawable()).getBitmap();
                dd4YouConfig.shareWithImage("Share with image test", bitmap);
              //  dd4YouConfig.shareWithImage("testimage", "Share with image test", bitmap); // you can pass image name also
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
                "\nCurrent Date: " + dd4YouConfig.getCurrentDate("dd-mm-yyyy") +
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
                "\nTime ago: "+ dd4YouConfig.getTimeAgo(1590143400)+
                "\nRandom Digits: "+ dd4YouConfig.generateRandomDigits()+
                "\nDD4You Number Format: " + dd4YouConfig.dd4youNumberFormat(2000);
        textView.setText(test);
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
