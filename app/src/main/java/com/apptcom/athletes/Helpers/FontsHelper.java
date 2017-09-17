package com.apptcom.athletes.Helpers;

import android.content.Context;
import android.graphics.Typeface;

import athletes.apptcom.com.athletes.R;

public abstract class FontsHelper {

    public static Typeface regTypeface(Context context)
    {
        return Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_reg));
    }
    public static Typeface boldTypeface(Context context)
    {
        return Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_bold));
    }

}
