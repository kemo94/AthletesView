package com.apptcom.athletes.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

import com.apptcom.athletes.Helpers.IntentOperations;

import athletes.apptcom.com.athletes.R;

public class SplashActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int secondsDelayed = 2;

        new Handler().postDelayed(new Runnable() {
            public void run() {
                IntentOperations.goToActivity(SplashActivity.this, HomeActivity.class,null);
                finish();
            }
        }, secondsDelayed * 1000);
    }

}
