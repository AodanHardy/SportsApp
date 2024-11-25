package com.example.sportsapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.sportsapp.Database.League;

import java.util.List;

@Dao
public interface LeagueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLeagues(List<League> leagues);

    @Query("SELECT * FROM leagues")
    List<League> getAllLeagues();
}
