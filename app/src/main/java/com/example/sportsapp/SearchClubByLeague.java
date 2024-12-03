package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.example.sportsapp.API.SportsApiClient;
import com.example.sportsapp.Database.AppDatabase;
import com.example.sportsapp.Database.ClubDao;
import com.example.sportsapp.Mappers.ClubMapper;
import com.example.sportsapp.Database.Club;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * The type Search club by league.
 */
public class SearchClubByLeague extends AppCompatActivity {

    /**
     * The Btn retrieve clubs.
     */
    Button btnRetrieveClubs, /**
     * The Btn save clubs to db.
     */
    btnSaveClubsToDB, /**
     * The Back btn.
     */
    backBtn;
    /**
     * The Club search.
     */
    EditText clubSearch;
    /**
     * The Clubs.
     */
    List<Club> clubs;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_club_by_league);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "leagues_db")
                .fallbackToDestructiveMigration()
                .build();

        clubs = new ArrayList<>();

        btnRetrieveClubs = findViewById(R.id.btnRetrieveClubs);
        btnSaveClubsToDB = findViewById(R.id.btnSaveClubsToDB);
        clubSearch = findViewById(R.id.editTextLeagueSearch);

        backBtn = findViewById(R.id.searchClubByLeagueBackBtn);



        SportsApiClient client = new SportsApiClient();


        // back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchClubByLeague.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnRetrieveClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = clubSearch.getText().toString();
                clubSearch.setText("");

                client.getAllTeamsByLeague(searchText, new SportsApiClient.ApiCallback() {
                    @Override
                    public void onSuccess(String result) {

                        clubs.addAll(ClubMapper.mapJsonToClubs(result));

                        // If there are clubs pass them to the fragment
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
                    ClubDao clubDao = db.clubDao();
                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            clubDao.insertClubs(clubs);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SearchClubByLeague.this, clubs.size() + " clubs added to the database.", Toast.LENGTH_SHORT).show();
                                    clearScreen(); // Clear the screen
                                }
                            });
                        }
                    });
                }
            }
        });
    }
    private void clearScreen() {
        // Clear the clubs list
        clubs.clear();

        // Notify the adapter that the data has changed
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ClubFragment fragment = ClubFragment.newInstance(clubs);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, fragment);
                transaction.commit();
            }
        });
    }

}
