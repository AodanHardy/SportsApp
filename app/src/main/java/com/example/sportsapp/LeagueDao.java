package com.example.sportsapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LeagueDao {
    @Insert
    void insertLeagues(League... leagues);

    @Query("SELECT * FROM leagues")
    List<League> getAllLeagues();
}
