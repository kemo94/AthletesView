package com.apptcom.athletes.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import athletes.apptcom.com.athletes.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class AthleteViewHolder extends RecyclerView.ViewHolder   {

    //declaration
    public TextView athleteNameTxv;
    public CircleImageView athleteImageImv;
    public LinearLayout openProfileLayout;
    public AthleteViewHolder(View view) {
        super(view);
        athleteNameTxv = (TextView) view.findViewById(R.id.athleteName_txv);
        athleteImageImv = (CircleImageView) view.findViewById(R.id.athleteImage_imv);
        openProfileLayout = (LinearLayout) view.findViewById(R.id.openProfile_layout);

    }
}
