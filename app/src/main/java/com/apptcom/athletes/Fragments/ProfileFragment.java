package com.apptcom.athletes.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import athletes.apptcom.com.athletes.R;


public class ProfileFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setRetainInstance(true);

    }
}
