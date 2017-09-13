package com.apptcom.athletes.Model.Responses;


import com.apptcom.athletes.Model.Data.Athlete;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AthletesResponse {

    @SerializedName("athletes")
    @Expose
    private ArrayList<Athlete> athletesArrayList;

    public ArrayList<Athlete> getAthletesArrayList() {
        return athletesArrayList;
    }
}