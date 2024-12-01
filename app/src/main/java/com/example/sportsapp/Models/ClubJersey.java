package com.example.sportsapp.Models;

import java.util.List;

/**
 * The type Club.
 */
public class ClubJersey {
    private String id;
    private String name;

    private List<String> jerseyUrls;

    public ClubJersey(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getJerseyUrls() {
        return jerseyUrls;
    }

    public void setJerseyUrls(List<String> jerseyUrls) {
        this.jerseyUrls = jerseyUrls;
    }
    public void addJersey(String jerseyUrl) {
        this.jerseyUrls.add(jerseyUrl);
    }
}

