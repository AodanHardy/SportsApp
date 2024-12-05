package com.example.sportsapp.Database;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class LeagueDaoTest {

    private LeagueDao leagueDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        leagueDao = db.leagueDao();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void insertAndGetAllLeagues() {
        List<League> leagues = new ArrayList<>();
        leagues.add(new League("1", "Premier League",
                "Soccer", "EPL"));
        leagues.add(new League("2", "La Liga",
                "Soccer", "Spanish League"));

        leagueDao.insertLeagues(leagues);
        List<League> fetchedLeagues = leagueDao.getAllLeagues();

        assertEquals(2, fetchedLeagues.size());
        assertEquals("Premier League", fetchedLeagues.get(0).getStrLeague());
        assertEquals("Soccer", fetchedLeagues.get(0).getStrSport());
        assertEquals("EPL", fetchedLeagues.get(0).getStrLeagueAlternate());
        assertEquals("La Liga", fetchedLeagues.get(1).getStrLeague());
    }

    @Test
    public void insertDuplicateLeagues_replacesExisting() {
        List<League> leagues = new ArrayList<>();
        leagues.add(new League("1", "Premier League",
                "Soccer", "EPL"));

        List<League> updatedLeagues = new ArrayList<>();
        updatedLeagues.add(new League("1", "Updated Premier League",
                "Football", "English Premier"));

        // Act: Insert initial leagues, then update
        leagueDao.insertLeagues(leagues);
        leagueDao.insertLeagues(updatedLeagues);

        List<League> fetchedLeagues = leagueDao.getAllLeagues();

        // Assert: Verify the league is updated
        assertEquals(1, fetchedLeagues.size());
        assertEquals("Updated Premier League", fetchedLeagues.get(0).getStrLeague());
        assertEquals("Football", fetchedLeagues.get(0).getStrSport());
        assertEquals("English Premier", fetchedLeagues.get(0).getStrLeagueAlternate());
    }

    @Test
    public void getAllLeagues_noData_returnsEmptyList() {
        List<League> fetchedLeagues = leagueDao.getAllLeagues();

        assertEquals(0, fetchedLeagues.size());
    }
}
