package com.apptcom.athletes.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apptcom.athletes.Adapters.AthletesAdapter;
import com.apptcom.athletes.Helpers.API;
import com.apptcom.athletes.Helpers.DialogsOperations;
import com.apptcom.athletes.Helpers.ToastOperations;
import com.apptcom.athletes.Model.Data.Athlete;
import com.apptcom.athletes.Model.Responses.AthletesResponse;

import java.util.ArrayList;

import athletes.apptcom.com.athletes.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class HomeActivity extends AppCompatActivity {
    public Call<AthletesResponse> callAthleteApi ;
    RecyclerView athleteRecycler;
    AthletesAdapter athletesAdapter ;
    ArrayList<Athlete> athletesArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }
    public void initView(){

        athleteRecycler = (RecyclerView) findViewById(R.id.athlete_recycler);
        athletesAdapter = new AthletesAdapter(HomeActivity.this,athletesArrayList);

        final LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.VERTICAL,false);
        athleteRecycler.setLayoutManager(linearLayoutManager);
        athleteRecycler.setAdapter(athletesAdapter);

    }
    public void prepareView() {
        athletesArrayList.clear();
        athletesAdapter.notifyDataSetChanged();
        getAthletes();
    }

    public void getAthletes(){
        DialogsOperations.viewLoading(HomeActivity.this);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API.BASE_URL)
                .build();

        API.GetAthletesApi apiInterface = retrofit.create( API.GetAthletesApi.class);
        callAthleteApi = apiInterface.getAthletes();

        callAthleteApi.enqueue(new Callback<AthletesResponse>() {
            @Override
            public void onResponse(Call<AthletesResponse> call, Response<AthletesResponse> response) {
                DialogsOperations.dismissLoading();
                switch (response.code()) {

                    case 200:
                        if ( response.body().getAthletesArrayList() != null  ){

                            athletesArrayList.addAll(response.body().getAthletesArrayList());
                            athletesAdapter.notifyDataSetChanged();

                        }

                        break;
                    default:
                        ToastOperations.showToast(getResources().getString(R.string.something_went_wrong),HomeActivity.this);
                }
            }

            @Override
            public void onFailure(Call<AthletesResponse> call, Throwable t) {
                DialogsOperations.dismissLoading();
                ToastOperations.showToast(getResources().getString(R.string.something_went_wrong),HomeActivity.this);
            }
        });

    }

    @Override
    protected void onResume() {
        prepareView();
        super.onResume();
    }

    @Override
    protected void onPause() {
        callAthleteApi.cancel();
        super.onPause();
    }
}
