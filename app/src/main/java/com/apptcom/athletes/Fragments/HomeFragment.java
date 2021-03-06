package com.apptcom.athletes.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apptcom.athletes.Activities.ProfileActivity;
import com.apptcom.athletes.Adapters.AthletesAdapter;
import com.apptcom.athletes.Helpers.APIHelper;
import com.apptcom.athletes.Helpers.DialogsHelper;
import com.apptcom.athletes.Helpers.IntentHelper;
import com.apptcom.athletes.Helpers.ToastHelper;
import com.apptcom.athletes.Model.Data.Athlete;
import com.apptcom.athletes.Model.Responses.AthletesResponse;

import java.util.ArrayList;

import athletes.apptcom.com.athletes.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    ProfileFragment profileFragment ;

    public Call<AthletesResponse> callAthleteApi ;
    RecyclerView athleteRecycler;
    AthletesAdapter athletesAdapter ;
    ArrayList<Athlete> athletesArrayList = new ArrayList<>();
    int currentPosition ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (savedInstanceState != null)
            athletesArrayList = savedInstanceState.getParcelableArrayList("athleteList");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);
        listeners();

        return view;
    }

    public void setProfileFragment(ProfileFragment profileFragment) {
        this.profileFragment = profileFragment;

    }

    public void initView(View view){

        athleteRecycler = (RecyclerView) view.findViewById(R.id.athlete_recycler);
        athletesAdapter = new AthletesAdapter(getActivity(),athletesArrayList);

        final LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        athleteRecycler.setLayoutManager(linearLayoutManager);
        athleteRecycler.setAdapter(athletesAdapter);

    }
    public void listeners(){

        athletesAdapter.setOnItemClickListener(new AthletesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Athlete athlete) {
                currentPosition = position;
                if ( profileFragment != null ){
                    profileFragment.setAthlete(athletesArrayList.get(position));
                }else{
                    Bundle bundleData = new Bundle();
                    bundleData.putParcelable("athlete",athletesArrayList.get(position));
                    IntentHelper.goToActivity(getActivity(),ProfileActivity.class,bundleData);

                }
            }
        });
    }
    public void prepareView() {

        athletesArrayList.clear();
        athletesAdapter.notifyDataSetChanged();
        getAthletes();
    }

    public void getAthletes(){
        DialogsHelper.viewLoading(getActivity());

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(APIHelper.BASE_URL)
                .build();

        APIHelper.GetAthletesApi apiInterface = retrofit.create( APIHelper.GetAthletesApi.class);
        callAthleteApi = apiInterface.getAthletes();

        callAthleteApi.enqueue(new Callback<AthletesResponse>() {
            @Override
            public void onResponse(Call<AthletesResponse> call, Response<AthletesResponse> response) {
                DialogsHelper.dismissLoading();
                switch (response.code()) {

                    case 200:
                        if ( response.body().getAthletesArrayList() != null  ){

                            athletesArrayList.addAll(response.body().getAthletesArrayList());
                            athletesAdapter.notifyDataSetChanged();
                            if ( profileFragment != null )
                                profileFragment.setAthlete(athletesArrayList.get(0));
                        }

                        break;
                    default:
                        ToastHelper.showToast(getResources().getString(R.string.something_went_wrong),getActivity());
                }
            }

            @Override
            public void onFailure(Call<AthletesResponse> call, Throwable t) {
                DialogsHelper.dismissLoading();
                ToastHelper.showToast(getResources().getString(R.string.something_went_wrong),getActivity());
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        if ( athletesArrayList.size() > 0 ) {
            outState.putParcelableArrayList("athleteList", athletesArrayList);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {

        if ( athletesArrayList.size() == 0 )
            prepareView();
        else {
            if (profileFragment != null)
              profileFragment.setAthlete(athletesArrayList.get(currentPosition));
        }

        super.onResume();
    }

    @Override
    public void onPause() {
        callAthleteApi.cancel();
        super.onPause();
    }
}
