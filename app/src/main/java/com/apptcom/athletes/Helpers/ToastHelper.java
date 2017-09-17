package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.widget.Toast;


public abstract class ToastHelper {


    public static void showToast(String message, Activity activity) {
        if ( activity !=null )
           Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
    }


}
