package com.apptcom.athletes.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apptcom.athletes.Helpers.ImageHelper;
import com.apptcom.athletes.Model.Data.Athlete;

import athletes.apptcom.com.athletes.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

    CircleImageView athleteImageImv ;
    Athlete athlete ;
    TextView athleteBriefTxv , athleteNameTxv ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if ( savedInstanceState != null )
            athlete = savedInstanceState.getBundle("data").getParcelable("athlete");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(view);

        return view ;
    }

    public void initView(View view){
        athleteImageImv = (CircleImageView) view.findViewById(R.id.athleteImage_imv);
        athleteNameTxv = (TextView) view.findViewById(R.id.athleteName_txv);
        athleteBriefTxv = (TextView) view.findViewById(R.id.athleteBrief_txv);
    }

    public void prepareView(){
        ImageHelper.downloadImage(getActivity(),athlete.getImage() , R.drawable.holder_athlete , athleteImageImv);
        athleteNameTxv.setText(athlete.getName());
        athleteBriefTxv.setText(athlete.getBrief());
    }
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete ;
        prepareView();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle bundle = new Bundle();
        bundle.putParcelable("athlete", athlete);
        outState.putBundle("data",bundle);

    }
}
