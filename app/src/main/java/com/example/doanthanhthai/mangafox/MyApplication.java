package com.example.doanthanhthai.mangafox;

import androidx.multidex.MultiDexApplication;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.doanthanhthai.mangafox.share.PreferenceHelper;

/**
 * Created by DOAN THANH THAI on 7/6/2018.
 */

public class MyApplication extends MultiDexApplication {
    protected String userAgent;



    @Override
    public void onCreate() {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        if (PreferenceHelper.getInstance(this).getNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        super.onCreate();
//        userAgent = Util.getUserAgent(this, "ExoPlayerDemo");


    }

}
