package com.example.sportsapp.Database;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;


public class ClubTest {

    @Test
    public void testClubConstructorAndGetters() {
        Club club = new Club(
                1, "Club Name", "Short Name", "Alt Name", 1900,
                "League", "League123", "Stadium Name", "Keywords",
                "Stadium Location", 50000, "https://website.com", "https://logo.url"
        );

        assertEquals(1, club.getId());
        assertEquals("Club Name", club.getName());
        assertEquals("Short Name", club.getShortName());
        assertEquals("Alt Name", club.getAlternateName());
        assertEquals(1900, club.getFormedYear());
        assertEquals("League", club.getLeague());
        assertEquals("League123", club.getLeagueId());
        assertEquals("Stadium Name", club.getStadium());
        assertEquals("Keywords", club.getKeywords());
        assertEquals("Stadium Location", club.getStadiumLocation());
        assertEquals(50000, club.getStadiumCapacity());
        assertEquals("https://website.com", club.getWebsite());
        assertEquals("https://logo.url", club.getLogoUrl());
    }

    @Test
    public void testSetters() {
        Club club = new Club(
                0, "", "", "", 0, "", "", "", "", "", 0, "", ""
        );

        club.setId(2);
        club.setName("New Name");
        club.setShortName("New Short");
        club.setAlternateName("New Alt");
        club.setFormedYear(2000);
        club.setLeague("New League");
        club.setLeagueId("League456");
        club.setStadium("New Stadium");
        club.setKeywords("New Keywords");
        club.setStadiumLocation("New Location");
        club.setStadiumCapacity(60000);
        club.setWebsite("https://newwebsite.com");
        club.setLogoUrl("https://newlogo.url");

        assertEquals(2, club.getId());
        assertEquals("New Name", club.getName());
        assertEquals("New Short", club.getShortName());
        assertEquals("New Alt", club.getAlternateName());
        assertEquals(2000, club.getFormedYear());
        assertEquals("New League", club.getLeague());
        assertEquals("League456", club.getLeagueId());
        assertEquals("New Stadium", club.getStadium());
        assertEquals("New Keywords", club.getKeywords());
        assertEquals("New Location", club.getStadiumLocation());
        assertEquals(60000, club.getStadiumCapacity());
        assertEquals("https://newwebsite.com", club.getWebsite());
        assertEquals("https://newlogo.url", club.getLogoUrl());
    }
}
