package com.apptcom.athletes.Views;


import android.content.Context;
import android.util.AttributeSet;

import com.apptcom.athletes.Helpers.FontsHelper;


public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        this.setTypeface(FontsHelper.regTypeface(context));

    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(FontsHelper.regTypeface(context));

    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setTypeface(FontsHelper.regTypeface(context));

    }

}

