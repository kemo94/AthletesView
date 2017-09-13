package com.apptcom.athletes.Helpers;

import com.apptcom.athletes.Model.Responses.AthletesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kemo on 9/13/2017.
 */

public class API {
    public static final String BASE_URL = "https://gist.githubusercontent.com" ;

    public interface GetAthletesApi {

        @GET("/Bassem-Samy/f227855df4d197d3737c304e9377c4d4/raw/ece2a30b16a77ee58091886bf6d3445946e10a23/athletes.josn")
        Call<AthletesResponse> getAthletes();
    }
}
