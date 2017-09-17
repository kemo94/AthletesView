package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract class IntentHelper {


    // go to another activity

    public static void goToActivity(Activity currentActivity, Class targetClass, Bundle value) {

        Intent intent = new Intent(currentActivity, targetClass);
        intent.putExtra("data", value);
        currentActivity.startActivity(intent);
    }

}