package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sportsapp.Database.AppDatabase;
import com.example.sportsapp.Database.League;
import com.example.sportsapp.Database.LeagueDao;

import androidx.room.Room;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button addLeagueToDb, searchForClubByLeague,searchForClub;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "leagues_db").build();

        addLeagueToDb = findViewById(R.id.btnAddLeaguesToDb);
        searchForClubByLeague = findViewById(R.id.btnSearchForClubsByLeague);
        searchForClub = findViewById(R.id.btnSearchForClubs);

        addLeagueToDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(()->{
                    populateLeagues();

                }).start();
            }
        });

        searchForClubByLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchClubByLeague.class);

                startActivity(intent);


            }
        });


        searchForClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchForClubs.class);
                startActivity(intent);
            }
        });

    }


    private void populateLeagues() {
        LeagueDao leagueDao = db.leagueDao();


        List<League> leagues = Arrays.asList(
                new League("4330", "Scottish Premier League", "Soccer", "Scottish Premiership, SPFL"),
                new League("4331", "German Bundesliga", "Soccer", "Bundesliga, Fußball-Bundesliga"),
                new League("4332", "Italian Serie A", "Soccer", "Serie A"),
                new League("4334", "French Ligue 1", "Soccer", "Ligue 1 Conforama"),
                new League("4335", "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga"),
                new League("4336", "Greek Superleague Greece", "Soccer", ""),
                new League("4337", "Dutch Eredivisie", "Soccer", "Eredivisie"),
                new League("4338", "Belgian Pro League", "Soccer", "Jupiler Pro League")
        );

        leagueDao.insertLeagues(leagues);
    }
}