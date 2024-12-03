package com.example.sportsapp.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * The type League.
 */
@Entity(tableName = "leagues")
public class League {
    @PrimaryKey
    @NonNull
    private String idLeague;

    private String strLeague;
    private String strSport;
    private String strLeagueAlternate;

    /**
     * Instantiates a new League.
     *
     * @param idLeague           the id league
     * @param strLeague          the str league
     * @param strSport           the str sport
     * @param strLeagueAlternate the str league alternate
     */
// Constructors, Getters, and Setters
    public League(@NonNull String idLeague, String strLeague, String strSport, String strLeagueAlternate) {
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strSport = strSport;
        this.strLeagueAlternate = strLeagueAlternate;
    }

    /**
     * Gets id league.
     *
     * @return the id league
     */
    @NonNull
    public String getIdLeague() {
        return idLeague;
    }

    /**
     * Sets id league.
     *
     * @param idLeague the id league
     */
    public void setIdLeague(@NonNull String idLeague) {
        this.idLeague = idLeague;
    }

    /**
     * Gets str league.
     *
     * @return the str league
     */
    public String getStrLeague() {
        return strLeague;
    }

    /**
     * Sets str league.
     *
     * @param strLeague the str league
     */
    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    /**
     * Gets str sport.
     *
     * @return the str sport
     */
    public String getStrSport() {
        return strSport;
    }

    /**
     * Sets str sport.
     *
     * @param strSport the str sport
     */
    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    /**
     * Gets str league alternate.
     *
     * @return the str league alternate
     */
    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    /**
     * Sets str league alternate.
     *
     * @param strLeagueAlternate the str league alternate
     */
    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }
}


