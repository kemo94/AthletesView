package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.widget.Toast;


public abstract class ToastOperations {


    public static void showToast(String message, Activity activity) {
        Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
    }


}
