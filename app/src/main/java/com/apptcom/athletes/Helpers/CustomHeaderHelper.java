package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import athletes.apptcom.com.athletes.R;


public abstract class CustomHeaderHelper {

    public static void setToolbar(final Activity activity, String title) {

        Toolbar toolbar = (Toolbar)activity.findViewById(R.id.toolbar);
        TextView titleTxv = (TextView)toolbar.findViewById(R.id.toolbar_title);
        ImageView icBackImv = (ImageView)toolbar.findViewById(R.id.ic_back);

        icBackImv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });

        titleTxv.setText(title);
    }

}
