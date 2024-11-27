package com.example.sportsapp.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clubs")
public class Club {

    @PrimaryKey
    private int id;

    private String name;
    private String shortName;
    private String alternateName;
    private int formedYear;
    private String league;
    private String leagueId;
    private String stadium;
    private String keywords;
    private String stadiumLocation;
    private int stadiumCapacity;
    private String website;
    private String logoUrl;

    // Constructor
    public Club(int id, String name, String shortName, String alternateName, int formedYear,
                String league, String leagueId, String stadium, String keywords,
                String stadiumLocation, int stadiumCapacity, String website, String logoUrl) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.alternateName = alternateName;
        this.formedYear = formedYear;
        this.league = league;
        this.leagueId = leagueId;
        this.stadium = stadium;
        this.keywords = keywords;
        this.stadiumLocation = stadiumLocation;
        this.stadiumCapacity = stadiumCapacity;
        this.website = website;
        this.logoUrl = logoUrl;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public int getFormedYear() {
        return formedYear;
    }

    public void setFormedYear(int formedYear) {
        this.formedYear = formedYear;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getStadiumLocation() {
        return stadiumLocation;
    }

    public void setStadiumLocation(String stadiumLocation) {
        this.stadiumLocation = stadiumLocation;
    }

    public int getStadiumCapacity() {
        return stadiumCapacity;
    }

    public void setStadiumCapacity(int stadiumCapacity) {
        this.stadiumCapacity = stadiumCapacity;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}

