package com.example.sportsapp.Models;

/**
 * The type Club.
 */
public class Club {
    private String id;
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


    /**
     * Instantiates a new Club.
     *
     * @param id              the id
     * @param name            the name
     * @param shortName       the short name
     * @param alternateName   the alternate name
     * @param formedYear      the formed year
     * @param league          the league
     * @param leagueId        the league id
     * @param stadium         the stadium
     * @param keywords        the keywords
     * @param stadiumLocation the stadium location
     * @param stadiumCapacity the stadium capacity
     * @param website         the website
     * @param logoUrl         the logo url
     */
    public Club(String id, String name, String shortName, String alternateName, int formedYear,
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


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets short name.
     *
     * @return the short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets short name.
     *
     * @param shortName the short name
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets alternate name.
     *
     * @return the alternate name
     */
    public String getAlternateName() {
        return alternateName;
    }

    /**
     * Sets alternate name.
     *
     * @param alternateName the alternate name
     */
    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    /**
     * Gets formed year.
     *
     * @return the formed year
     */
    public int getFormedYear() {
        return formedYear;
    }

    /**
     * Sets formed year.
     *
     * @param formedYear the formed year
     */
    public void setFormedYear(int formedYear) {
        this.formedYear = formedYear;
    }

    /**
     * Gets league.
     *
     * @return the league
     */
    public String getLeague() {
        return league;
    }

    /**
     * Sets league.
     *
     * @param league the league
     */
    public void setLeague(String league) {
        this.league = league;
    }

    /**
     * Gets league id.
     *
     * @return the league id
     */
    public String getLeagueId() {
        return leagueId;
    }

    /**
     * Sets league id.
     *
     * @param leagueId the league id
     */
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    /**
     * Gets stadium.
     *
     * @return the stadium
     */
    public String getStadium() {
        return stadium;
    }

    /**
     * Sets stadium.
     *
     * @param stadium the stadium
     */
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    /**
     * Gets keywords.
     *
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Sets keywords.
     *
     * @param keywords the keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Gets stadium location.
     *
     * @return the stadium location
     */
    public String getStadiumLocation() {
        return stadiumLocation;
    }

    /**
     * Sets stadium location.
     *
     * @param stadiumLocation the stadium location
     */
    public void setStadiumLocation(String stadiumLocation) {
        this.stadiumLocation = stadiumLocation;
    }

    /**
     * Gets stadium capacity.
     *
     * @return the stadium capacity
     */
    public int getStadiumCapacity() {
        return stadiumCapacity;
    }

    /**
     * Sets stadium capacity.
     *
     * @param stadiumCapacity the stadium capacity
     */
    public void setStadiumCapacity(int stadiumCapacity) {
        this.stadiumCapacity = stadiumCapacity;
    }

    /**
     * Gets website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets website.
     *
     * @param website the website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets logo url.
     *
     * @return the logo url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * Sets logo url.
     *
     * @param logoUrl the logo url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
