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
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray teamsArray = jsonObject.getJSONArray("teams");

            for (int i = 0; i < teamsArray.length(); i++) {
                JSONObject teamJson = teamsArray.getJSONObject(i);

                String id = teamJson.optString("idTeam", null);
                String name = teamJson.optString("strTeam", null);
                String shortName = teamJson.optString("strTeamShort", null);
                String alternateName = teamJson.optString("strTeamAlternate", null);
                int formedYear = teamJson.optInt("intFormedYear", -1);
                String league = teamJson.optString("strLeague", null);
                String leagueId = teamJson.optString("idLeague", null);
                String stadium = teamJson.optString("strStadium", null);
                String keywords = teamJson.optString("strKeywords", null);
                String stadiumLocation = teamJson.optString("strLocation", null);
                int stadiumCapacity = teamJson.optInt("intStadiumCapacity", -1);
                String website = teamJson.optString("strWebsite", null);
                String logoUrl = teamJson.optString("strLogo", null);

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
