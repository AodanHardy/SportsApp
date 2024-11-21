package com.example.sportsapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sportsapp.Database.League;

import java.util.List;

@Dao
public interface LeagueDao {
    @Insert
    void insertLeagues(League... leagues);

    @Query("SELECT * FROM leagues")
    List<League> getAllLeagues();
}
