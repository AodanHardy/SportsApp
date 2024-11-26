package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.FragmentTransaction;
import com.example.sportsapp.API.SportsApiClient;
import com.example.sportsapp.Mappers.ClubMapper;
import com.example.sportsapp.Models.Club;

import java.util.ArrayList;
import java.util.List;

public class SearchClubByLeague extends AppCompatActivity {

    Button btnRetrieveClubs, btnSaveClubsToDB;
    EditText clubSearch;
    List<Club> clubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_club_by_league);

        clubs = new ArrayList<>();

        btnRetrieveClubs = findViewById(R.id.btnRetrieveClubs);
        btnSaveClubsToDB = findViewById(R.id.btnSaveClubsToDB);
        clubSearch = findViewById(R.id.editTextClubSearch);



        SportsApiClient client = new SportsApiClient();

        btnRetrieveClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = clubSearch.getText().toString();

                client.getAllTeamsByLeague(searchText, new SportsApiClient.ApiCallback() {
                    @Override
                    public void onSuccess(String result) {

                        clubs.addAll(ClubMapper.mapJsonToClubs(result));

                        // If there are clubs, pass them to the fragment
                        if (clubs != null && !clubs.isEmpty()) {
                            ClubFragment fragment = ClubFragment.newInstance(clubs);
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragmentContainer, fragment);
                            transaction.commit();
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        System.err.println("Failed to fetch data: " + e.getMessage());
                    }
                });
            }
        });

        btnSaveClubsToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if clubs has anything

                if (!clubs.isEmpty()) {
                    // if ture save clubs to database

                }
            }
        });
    }
}
