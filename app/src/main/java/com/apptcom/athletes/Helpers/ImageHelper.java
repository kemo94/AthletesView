package com.apptcom.athletes.Helpers;

import android.app.Activity;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public abstract class ImageHelper {

    public static void downloadImage(Activity activity , String imageUrl , int placeHolder, ImageView imageView){

        if ( imageUrl != "" && imageUrl != null)
        {
            try {
                Picasso.with(activity).load(imageUrl)
                        .placeholder(placeHolder)
                        .resize(100,100)
                        .into(imageView);
            } catch (Exception e) {
                imageView.setImageResource(placeHolder);
            }
        }else
             imageView.setImageResource(placeHolder);

    }


}