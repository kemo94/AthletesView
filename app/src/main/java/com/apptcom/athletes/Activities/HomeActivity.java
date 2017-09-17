package com.apptcom.athletes.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.apptcom.athletes.Fragments.HomeFragment;
import com.apptcom.athletes.Fragments.ProfileFragment;
import com.apptcom.athletes.Helpers.DialogsHelper;
import com.apptcom.athletes.Helpers.Utility;

import athletes.apptcom.com.athletes.R;
public class HomeActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    ProfileFragment profileFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onRetainNonConfigurationInstance();

        if (!Utility.checkNetworkStatus(this))
            DialogsHelper.showNoInternetDialog(this);

        else
            if (savedInstanceState == null || homeFragment == null ){
                setContentView(R.layout.activity_home);
                homeFragment =(HomeFragment)getSupportFragmentManager().findFragmentById(R.id.home_fragment);
                profileFragment =(ProfileFragment)  getSupportFragmentManager().findFragmentById(R.id.profile_fragment);
                homeFragment.setProfileFragment(profileFragment);
            }
     }
}
