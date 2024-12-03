package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportsapp.Database.AppDatabase;
import com.example.sportsapp.Database.Club;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * The type Search for clubs.
 */
public class SearchForClubs extends AppCompatActivity {
    /**
     * The Search txt.
     */
    EditText searchTxt;
    /**
     * The Search btn.
     */
    Button searchBtn, /**
     * The Back btn.
     */
    backBtn;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_clubs);

        searchBtn = findViewById(R.id.btnSearchClub);
        backBtn = findViewById(R.id.searchForClubBackBtn);

        searchTxt = findViewById(R.id.editTextClubSearch);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "leagues_db")
                .fallbackToDestructiveMigration()
                .build();

        RecyclerView recyclerView = findViewById(R.id.clubSearchResultsRecyclerView);
        ClubRecyclerViewAdapter adapter = new ClubRecyclerViewAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchForClubs.this, MainActivity.class );
                startActivity(intent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = searchTxt.getText().toString();

                if (!searchText.isEmpty()) {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        List<Club> results = db.clubDao().searchClubs(searchText);

                        runOnUiThread(() -> {
                            adapter.updateData(results);
                        });
                    });
                }
            }
        });
    }
}