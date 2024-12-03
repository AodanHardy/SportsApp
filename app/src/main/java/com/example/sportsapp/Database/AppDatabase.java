package com.example.sportsapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * The Room database for App.
 */
@Database(entities = {League.class, Club.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    /**
     * League dao league dao.
     *
     * @return the league dao
     */
    public abstract LeagueDao leagueDao();

    /**
     * Club dao club dao.
     *
     * @return the club dao
     */
    public abstract ClubDao clubDao();
}
