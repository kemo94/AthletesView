package com.apptcom.athletes.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.apptcom.athletes.Fragments.HomeFragment;
import com.apptcom.athletes.Fragments.ProfileFragment;

import athletes.apptcom.com.athletes.R;
public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        onRetainNonConfigurationInstance();

        if (savedInstanceState == null){
            HomeFragment homeFragment =(HomeFragment)getSupportFragmentManager().findFragmentById(R.id.home_fragment);
            ProfileFragment profileFragment =(ProfileFragment)  getSupportFragmentManager().findFragmentById(R.id.profile_fragment);
            homeFragment.setProfileFragment(profileFragment);

        }
     }
}
