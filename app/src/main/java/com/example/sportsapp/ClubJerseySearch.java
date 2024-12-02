package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    Button clubJerseySearchBtn;
    EditText clubSearchTxt;
    SportsApiClient client;
    RecyclerView recyclerView;
    ClubJerseyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_jersey_search);

        clubJerseySearchBtn = findViewById(R.id.btnJerseyClubSearch);
        recyclerView = findViewById(R.id.clubJerseyRecyclerView);
        clubSearchTxt = findViewById(R.id.editTextJerseySearch);
        client = new SportsApiClient();

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClubJerseyRecyclerViewAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        clubJerseySearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ClubJersey> clubsList = new ArrayList<>();
                String searchText = clubSearchTxt.getText().toString();

                client.getAllTeamsByLeague("English Premier League", new SportsApiClient.ApiCallback() {
                    @Override
                    public void onSuccess(String result) {
                        List<ClubJersey> clubs = ClubMapper.mapJsonToClubJersey(result, searchText);

                        for (int i = 0; i < clubs.size(); i++) {
                            int finalI = i;
                            client.getJerseysForClub(clubs.get(finalI).getId(), new SportsApiClient.ApiCallback() {
                                @Override
                                public void onSuccess(String result) {
                                    clubs.get(finalI).setJerseyUrls(ClubMapper.mapJsonToJerseyList(result));

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