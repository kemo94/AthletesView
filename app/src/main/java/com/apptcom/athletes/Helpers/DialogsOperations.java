package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;

import athletes.apptcom.com.athletes.R;

/**
 * Created by m on 9/14/2017.
 */

public class DialogsOperations {


    public static Dialog dialog;

    public static void viewLoading(Activity activity) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void dismissLoading() {
        if ( dialog != null )
            dialog.dismiss();
    }

}
