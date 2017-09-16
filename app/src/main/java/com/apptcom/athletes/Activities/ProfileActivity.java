package com.apptcom.athletes.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.apptcom.athletes.Helpers.CustomHeader;
import com.apptcom.athletes.Helpers.ImageOperations;
import com.apptcom.athletes.Model.Data.Athlete;

import athletes.apptcom.com.athletes.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileActivity extends AppCompatActivity {

    CircleImageView athleteImageImv ;
    Athlete athlete ;
    TextView athleteBriefTxv , athleteNameTxv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initData();
        initView();
        prepareView();
    }
    public void initData(){
        Bundle bundle = getIntent().getBundleExtra("data");
        if ( bundle != null ){
            athlete = bundle.getParcelable("athlete");
        }
    }
    public void initView(){
        CustomHeader.setToolbar(ProfileActivity.this,athlete.getName());
        athleteImageImv = (CircleImageView) findViewById(R.id.athleteImage_imv);
        athleteNameTxv = (TextView) findViewById(R.id.athleteName_txv);
        athleteBriefTxv = (TextView) findViewById(R.id.athleteBrief_txv);

    }

    public void prepareView(){
        ImageOperations.downloadImage(ProfileActivity.this,athlete.getImage() , R.drawable.holder_athlete , athleteImageImv);
        athleteNameTxv.setText(athlete.getName());
        athleteBriefTxv.setText(athlete.getBrief());
    }
}
