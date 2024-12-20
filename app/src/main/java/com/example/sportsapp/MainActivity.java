package com.example.sportsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.sportsapp.Database.AppDatabase;
import com.example.sportsapp.Database.League;
import com.example.sportsapp.Database.LeagueDao;
import com.example.sportsapp.Logging.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    Logger logger;

    /**
     * The Add league to db btn.
     */
    Button addLeagueToDbBtn, /**
     * The Search for club by league btn.
     */
    searchForClubByLeagueBtn, /**
     * The Search for club btn.
     */
    searchForClubBtn, /**
     * The Jersey search btn.
     */
    jerseySearchBtn;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logger = new Logger(MainActivity.class);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "leagues_db").build();

        addLeagueToDbBtn = findViewById(R.id.btnAddLeaguesToDb);
        searchForClubByLeagueBtn = findViewById(R.id.btnSearchForClubsByLeague);
        searchForClubBtn = findViewById(R.id.btnSearchForClubs);
        jerseySearchBtn = findViewById(R.id.btnSearchClubJerseys);

        addLeagueToDbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(()->{
                    populateLeagues();
                }).start();
            }
        });

        searchForClubByLeagueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchClubByLeague.class);

                startActivity(intent);
            }
        });

        searchForClubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchForClubs.class);
                startActivity(intent);
            }
        });

        jerseySearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClubJerseySearch.class);
                startActivity(intent);
            }
        });
    }

    private void populateLeagues() {
        try {


            // populate database with leagues
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

            logger.info("LEAGUES ADDED TO DATABASE");

            // send msg to user
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, leagues.size() + " Leagues added to the database.", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            logger.error("ERROR ADDING LEAGUES TO DATABASE: " + e.getMessage()) ;
        }
    }
}