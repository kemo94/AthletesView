package com.apptcom.athletes.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apptcom.athletes.Fragments.ProfileFragment;
import com.apptcom.athletes.Helpers.CustomHeader;
import com.apptcom.athletes.Model.Data.Athlete;

import athletes.apptcom.com.athletes.R;


public class ProfileActivity extends AppCompatActivity {
    ProfileFragment profileFragment ;
    Athlete athlete ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        initData();
        initView();
        prepareView();
    }
    public void initView(){

        CustomHeader.setToolbar(ProfileActivity.this,athlete.getName());
        profileFragment = (ProfileFragment) getSupportFragmentManager().findFragmentById(R.id.profile_fragment);

    }

    public void initData(){
        Bundle bundle = getIntent().getBundleExtra("data");
        if ( bundle != null ){
            athlete = bundle.getParcelable("athlete");
        }

    }

    public void prepareView(){
        profileFragment.setAthlete(athlete);
    }
}
