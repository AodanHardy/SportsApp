package com.example.sportsapp.Database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
public class ClubDaoTest {
    private ClubDao clubDao;
    private AppDatabase db;


    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        clubDao = db.clubDao();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void testInsertAndRetrieveClub() {
        Club club = new Club(1, "Manchester United", "Man utd",
                "MU", 1870, "Premier League", "111",
                "Old trafford", "none", "Manchester",
                74000, "manutd.com", "manutd.com/logo");
        clubDao.insertClub(club);

        List<Club> clubs = clubDao.getAllClubs();
        assertEquals(1, clubs.size());
        assertEquals("Manchester United", clubs.get(0).getName());
    }

    @Test
    public void testInsertAndRetrieveMultipleClubs() {
        List<Club> clubList = new ArrayList<>();

        clubList.add(new Club(1, "Manchester United", "Man utd",
                "MU", 1870, "Premier League", "111",
                "Old trafford", "none", "Manchester",
                74000, "manutd.com", "manutd.com/logo"));


        clubList.add(new Club(1, "Liverpool Football Club", "Liverpool",
                "LFC", 1870, "Premier League", "111",
                "Anfeild", "none", "Liverpool",
                64000, "liverpool.com", "liverpool.com/logo"));

        clubDao.insertClubs(clubList);

        List<Club> clubs = clubDao.getAllClubs();
        assertEquals(2, clubs.size());
    }

    @Test
    public void testDeleteAllClubs() {
        Club club = new Club(1, "Manchester United", "Man utd",
                "MU", 1870, "Premier League", "111",
                "Old trafford", "none", "Manchester",
                74000, "manutd.com", "manutd.com/logo");
        clubDao.insertClub(club);

        clubDao.deleteAllClubs();

        List<Club> clubs = clubDao.getAllClubs();
        assertTrue(clubs.isEmpty());
    }

    @Test
    public void testSearchClubs() {
        List<Club> clubList = new ArrayList<>();

        clubList.add(new Club(1, "Manchester United", "Man utd",
                "MU", 1870, "Premier League", "111",
                "Old trafford", "none", "Manchester",
                74000, "manutd.com", "manutd.com/logo"));


        clubList.add(new Club(1, "Liverpool Football Club", "Liverpool",
                "LFC", 1870, "Premier League", "111",
                "Anfeild", "none", "Liverpool",
                64000, "liverpool.com", "liverpool.com/logo"));

        clubDao.insertClubs(clubList);

        List<Club> result = clubDao.searchClubs("Man");
        assertEquals(1, result.size());
        assertEquals("Manchester United", result.get(0).getName());
    }

    @Test
    public void testGetClubsByLeague() {
        List<Club> clubList = new ArrayList<>();

        clubList.add(new Club(1, "Manchester United", "Man utd",
                "MU", 1870, "Premier League", "111",
                "Old trafford", "none", "Manchester",
                74000, "manutd.com", "manutd.com/logo"));


        clubList.add(new Club(1, "Liverpool Football Club", "Liverpool",
                "LFC", 1870, "Spanish La Liga", "111",
                "Anfeild", "none", "Liverpool",
                64000, "liverpool.com", "liverpool.com/logo"));

        clubDao.insertClubs(clubList);

        List<Club> result = clubDao.getClubsByLeague("Premier League");
        assertEquals(1, result.size());
        assertEquals("Manchester United", result.get(0).getName());
    }
}


