package com.example.sportsapp.Models;

import java.util.List;

/**
 * The type Club.
 */
public class ClubJersey {
    private String id;
    private String name;

    private List<String> jerseyUrls;

    /**
     * Instantiates a new Club jersey.
     *
     * @param id   the id
     * @param name the name
     */
    public ClubJersey(String id, String name) {
        this.id = id;
        this.name = name;
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
     * Gets jersey urls.
     *
     * @return the jersey urls
     */
    public List<String> getJerseyUrls() {
        return jerseyUrls;
    }

    /**
     * Sets jersey urls.
     *
     * @param jerseyUrls the jersey urls
     */
    public void setJerseyUrls(List<String> jerseyUrls) {
        this.jerseyUrls = jerseyUrls;
    }

    /**
     * Add jersey.
     *
     * @param jerseyUrl the jersey url
     */
    public void addJersey(String jerseyUrl) {
        this.jerseyUrls.add(jerseyUrl);
    }
}

