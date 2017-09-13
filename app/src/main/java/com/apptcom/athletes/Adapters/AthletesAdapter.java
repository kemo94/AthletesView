package com.apptcom.athletes.Adapters;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.apptcom.athletes.Activities.ProfileActivity;
import com.apptcom.athletes.Helpers.ImageOperations;
import com.apptcom.athletes.Helpers.IntentOperations;
import com.apptcom.athletes.Holders.AthleteViewHolder;
import com.apptcom.athletes.Model.Data.Athlete;

import athletes.apptcom.com.athletes.R;

public class AthletesAdapter extends RecyclerView.Adapter<AthleteViewHolder> {
    Activity activity;


    ArrayList<Athlete> athletesArrayList ;

    public AthletesAdapter(Activity activity, ArrayList<Athlete> athletesArrayList){
        this.activity=activity;
        this.athletesArrayList = athletesArrayList;
    }
    @Override
    public AthleteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_athlete, parent, false);

        return new AthleteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AthleteViewHolder athleteViewHolder, final int position) {
        athleteViewHolder.athleteNameTxv.setText(athletesArrayList.get(position).getName());
        ImageOperations.downloadImage(activity,athletesArrayList.get(position).getImage() , R.drawable.holder_athlete,athleteViewHolder.athleteImageImv);


        athleteViewHolder.openProfileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleData = new Bundle();
                bundleData.putParcelable("athlete",athletesArrayList.get(position));
                IntentOperations.goToActivity(activity,ProfileActivity.class,bundleData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return athletesArrayList.size();
    }


}

