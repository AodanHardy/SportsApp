package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportsapp.API.SportsApiClient;
import com.example.sportsapp.Mappers.ClubMapper;
import com.example.sportsapp.Models.ClubJersey;


import java.util.ArrayList;
import java.util.List;

public class ClubJerseySearch extends AppCompatActivity {
    Button clubJerseySearchBtn;
    EditText clubSearchTxt;
    SportsApiClient client;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_jersey_search);

        clubJerseySearchBtn = findViewById(R.id.btnJerseyClubSearch);

        recyclerView = findViewById(R.id.clubJerseyRecyclerView);
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

                                        if (finalI == clubs.size() - 1) {
                                        // send data to fragment here
                                            System.out.println();
                                            runOnUiThread(() -> {
                                                System.out.println(clubs);
                                            });
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
            }
        });
    }
}