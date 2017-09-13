package com.apptcom.athletes.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apptcom.athletes.Helpers.API;
import com.apptcom.athletes.Model.Responses.AthletesResponse;

import athletes.apptcom.com.athletes.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class HomeActivity extends AppCompatActivity {
    public Call<AthletesResponse> callAthleteApi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void getAthletes(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API.BASE_URL)
                .build();

        API.GetAthletesApi apiInterface = retrofit.create( API.GetAthletesApi.class);
        callAthleteApi = apiInterface.getAthletes();

        callAthleteApi.enqueue(new Callback<AthletesResponse>() {
            @Override
            public void onResponse(Call<AthletesResponse> call, Response<AthletesResponse> response) {
                switch (response.code()) {

                    case 200:
                        if (response.body() != null) {

                            if ( response.body().getAthletesArrayList() != null  ){

                            }
                        }
                        break;

                }
            }

            @Override
            public void onFailure(Call<AthletesResponse> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onResume() {
        getAthletes();
        super.onResume();
    }

    @Override
    protected void onPause() {
        callAthleteApi.cancel();
        super.onPause();
    }
}
