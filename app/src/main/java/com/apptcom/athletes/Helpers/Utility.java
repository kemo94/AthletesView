package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
public abstract class Utility {



    public static boolean checkNetworkStatus(Activity currentActivity) {

        ConnectivityManager connectivityManager = ((ConnectivityManager) currentActivity.getSystemService(
                Context.CONNECTIVITY_SERVICE));
        return (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected());
    }
}