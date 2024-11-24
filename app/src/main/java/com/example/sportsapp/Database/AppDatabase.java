package com.example.sportsapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {League.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LeagueDao leagueDao();
}
