package com.example.sportsapp.Mappers;


import com.example.sportsapp.Models.Club;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ClubMapper {

    public static List<Club> mapJsonToClubs(String jsonString) {
        List<Club> clubs = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(jsonString);
            JSONArray teamsArray = root.getJSONArray("teams");

            for (int i = 0; i < teamsArray.length(); i++) {
                JSONObject teamJson = teamsArray.getJSONObject(i);

                String id = teamJson.optString("idTeam", null);
                String name = teamJson.optString("Name", null);
                String shortName = teamJson.optString("strTeamShort", null);
                String alternateName = teamJson.optString("strAlternate", null);
                int formedYear = teamJson.optInt("intFormedYear", -1);
                String league = teamJson.optString("strLeague", null);
                String leagueId = teamJson.optString("idLeague", null);
                String stadium = teamJson.optString("strStadium", null);
                String keywords = teamJson.optString("strKeywords", null);
                String stadiumLocation = teamJson.optString("strStadiumLocation", null);
                int stadiumCapacity = teamJson.optInt("intStadiumCapacity", -1);
                String website = teamJson.optString("strWebsite", null);
                String logoUrl = teamJson.optString("strTeamLogo", null);

                Club club = new Club(id, name, shortName, alternateName, formedYear, league, leagueId, stadium,
                        keywords, stadiumLocation, stadiumCapacity, website, logoUrl);
                clubs.add(club);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clubs;
    }
}
