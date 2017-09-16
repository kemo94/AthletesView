package com.apptcom.athletes.Views;

import android.content.Context;
import android.util.AttributeSet;

import com.apptcom.athletes.Helpers.Fonts;

public class CustomTextViewBold extends android.support.v7.widget.AppCompatTextView {

    public CustomTextViewBold(Context context) {
        super(context);
        this.setTypeface(Fonts.boldTypeface(context));

    }

    public CustomTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Fonts.boldTypeface(context));

    }

    public CustomTextViewBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setTypeface(Fonts.boldTypeface(context));

    }
}
