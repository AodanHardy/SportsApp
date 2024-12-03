package com.example.sportsapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.sportsapp.Database.League;

import java.util.List;

/**
 * The interface League dao.
 */
@Dao
public interface LeagueDao {
    /**
     * Insert leagues.
     *
     * @param leagues the leagues
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLeagues(List<League> leagues);

    /**
     * Gets all leagues.
     *
     * @return the all leagues
     */
    @Query("SELECT * FROM leagues")
    List<League> getAllLeagues();
}
