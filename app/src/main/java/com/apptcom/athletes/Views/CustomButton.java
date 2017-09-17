package com.apptcom.athletes.Views;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.apptcom.athletes.Helpers.FontsHelper;


public class CustomButton extends android.support.v7.widget.AppCompatButton {

    public CustomButton(Context context) {
        super(context);
        this.setTypeface(FontsHelper.regTypeface(context));
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(FontsHelper.regTypeface(context));

    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setTypeface(FontsHelper.regTypeface(context));
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
    }
}
