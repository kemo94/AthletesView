package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import athletes.apptcom.com.athletes.R;


public class DialogsHelper {


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

    public static void showNoInternetDialog(final Activity currentActivity) {

        final Dialog noInternetDialog = new Dialog(currentActivity, R.style.DialogFullScreen);

        noInternetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        noInternetDialog.setContentView(R.layout.dialog_no_internet);
        noInternetDialog.setCancelable(false);

        noInternetDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        Button reloadBtn = (Button) noInternetDialog.findViewById(R.id.reload_button);

        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utility.checkNetworkStatus(currentActivity)) {
                    currentActivity.recreate();
                    noInternetDialog.dismiss();
                } else {
                    ToastHelper.showToast(currentActivity.getResources().getString(R.string.no_connection),currentActivity);
                }
            }
        });
        noInternetDialog.show();

    }
}
