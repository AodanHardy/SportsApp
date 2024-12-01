package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportsapp.API.SportsApiClient;
import com.example.sportsapp.Mappers.ClubMapper;
import com.example.sportsapp.Models.ClubJersey;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ClubJerseySearch extends AppCompatActivity {
    Button clubJerseySearchBtn;
    EditText clubSearchTxt;
    SportsApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_jersey_search);

        clubJerseySearchBtn = findViewById(R.id.btnJerseyClubSearch);

        clubSearchTxt = findViewById(R.id.editTextJerseySearch);
        client = new SportsApiClient();


        clubJerseySearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ClubJersey> clubsList = new ArrayList<>();
                String searchText = clubSearchTxt.getText().toString();

                // call to get all EPL clubs
                client.getAllTeamsByLeague("English Premier League", new SportsApiClient.ApiCallback() {
                    @Override
                    public void onSuccess(String result) {
                        List<ClubJersey> clubs = ClubMapper.mapJsonToClubJersey(result, searchText);

                        for (int i = 0; i<clubs.size(); i++){
                            int finalI = i;
                            client.getJerseysForClub(clubs.get(finalI).getId(), new SportsApiClient.ApiCallback() {
                                    @Override
                                    public void onSuccess(String result) {
                                        clubs.get(finalI).setJerseyUrls(ClubMapper.mapJsonToJerseyList(result));

                                        // check if this is the last club, if so, then send to UI
                                        if (finalI == clubs.size() - 1) {

                                        }
                                    }

                                    @Override
                                    public void onError(Exception e) {

                                    }
                                });
                        }


                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });



                // map valid clubs to list of ClubJerseys

                // call equipment API to get Jersey URLs


            }
        });

    }


}