package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sportsapp.API.APIAccessor;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button addLeagueToDb, searchForClubByLeague,searchForClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addLeagueToDb = findViewById(R.id.btnAddLeaguesToDb);
        searchForClubByLeague = findViewById(R.id.btnSearchForClubsByLeague);
        searchForClub = findViewById(R.id.btnSearchForClubs);



        // test


        // Fetch leagues in Scotland
        String country = "Scotland";


        addLeagueToDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddLeaguesToDb.class);

                startActivity(intent);


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
}