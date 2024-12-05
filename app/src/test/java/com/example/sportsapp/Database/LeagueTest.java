package com.example.sportsapp.Database;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class LeagueTest {

    @Test
    public void testLeagueConstructorAndGetters() {
        League league = new League("League123", "Premier League", "Football", "EPL");

        assertEquals("League123", league.getIdLeague());
        assertEquals("Premier League", league.getStrLeague());
        assertEquals("Football", league.getStrSport());
        assertEquals("EPL", league.getStrLeagueAlternate());
    }

    @Test
    public void testSetters() {
        League league = new League("", "", "", "");

        league.setIdLeague("1234");
        league.setStrLeague("La Liga");
        league.setStrSport("football");
        league.setStrLeagueAlternate("LL");

        assertEquals("1234", league.getIdLeague());
        assertEquals("La Liga", league.getStrLeague());
        assertEquals("football", league.getStrSport());
        assertEquals("LL", league.getStrLeagueAlternate());
    }
}
