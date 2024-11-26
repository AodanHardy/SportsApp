package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportsapp.API.SportsApiClient;
import com.example.sportsapp.Mappers.ClubMapper;
import com.example.sportsapp.Models.Club;

import java.util.List;

public class SearchClubByLeague extends AppCompatActivity {
    Button btnRetrieveClubs,btnSaveClubsToDB;
    EditText clubSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_club_by_league);

        btnRetrieveClubs = findViewById(R.id.btnRetrieveClubs);
        btnSaveClubsToDB = findViewById(R.id.btnSaveClubsToDB);
        clubSearch = findViewById(R.id.editTextClubSearch);

        SportsApiClient client = new SportsApiClient();

        btnRetrieveClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get text
                String searchText = clubSearch.getText().toString();


                // call API with text
                client.getAllTeamsByLeague(searchText, new SportsApiClient.ApiCallback() {
                    @Override
                    public void onSuccess(String result) {

                        List<Club> clubs = ClubMapper.mapJsonToClubs(result);

                        // if clubs is 0, then invalid search

                        System.out.println();

                        for (Club club : clubs) {
                            System.out.println();
                            // put clubs on screen
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        System.err.println("Failed to fetch data: " + e.getMessage());
                    }
                });

            }
        });
    }
}