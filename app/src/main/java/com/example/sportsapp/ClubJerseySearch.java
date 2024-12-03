package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportsapp.API.SportsApiClient;
import com.example.sportsapp.Models.ClubJersey;
import com.example.sportsapp.Mappers.ClubMapper;

import java.util.ArrayList;
import java.util.List;

public class ClubJerseySearch extends AppCompatActivity {
    private Button clubJerseySearchBtn, backBtn;
    private EditText clubSearchTxt;
    private SportsApiClient client;
    private RecyclerView recyclerView;
    private ClubJerseyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_jersey_search);

        // set up
        clubJerseySearchBtn = findViewById(R.id.btnJerseyClubSearch);
        backBtn = findViewById(R.id.jerseySearchBackBtn);
        recyclerView = findViewById(R.id.clubJerseyRecyclerView);
        clubSearchTxt = findViewById(R.id.editTextJerseySearch);
        client = new SportsApiClient();

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClubJerseyRecyclerViewAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClubJerseySearch.this, MainActivity.class);
                startActivity(intent);

            }
        });

        clubJerseySearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ClubJersey> clubsList = new ArrayList<>();
                String searchText = clubSearchTxt.getText().toString();

                client.getAllTeamsByLeague("English Premier League", new SportsApiClient.ApiCallback() {
                    @Override
                    public void onSuccess(String result) {
                        // get list oj ClubJersey objects from JSON
                        List<ClubJersey> clubs = ClubMapper.mapJsonToClubJersey(result, searchText);


                        for (int i = 0; i < clubs.size(); i++) {
                            int finalI = i;
                            client.getJerseysForClub(clubs.get(finalI).getId(), new SportsApiClient.ApiCallback() {
                                @Override
                                public void onSuccess(String result) {
                                    clubs.get(finalI).setJerseyUrls(ClubMapper.mapJsonToJerseyList(result));

                                    // if item is last on list, update table
                                    if (finalI == clubs.size() - 1) {
                                        runOnUiThread(() -> {
                                            adapter.updateData(clubs);
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