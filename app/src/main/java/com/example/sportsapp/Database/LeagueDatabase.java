package com.example.sportsapp.Database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {League.class}, version = 1, exportSchema = false)
public abstract class LeagueDatabase extends RoomDatabase {
    private static volatile LeagueDatabase instance;

    public abstract LeagueDao leagueDao();

    public static LeagueDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LeagueDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            LeagueDatabase.class, "league_database").build();
                }
            }
        }
        return instance;
    }
}

