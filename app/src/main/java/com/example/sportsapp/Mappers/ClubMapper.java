package com.example.sportsapp.Mappers;


import com.example.sportsapp.Database.Club;
import com.example.sportsapp.Models.ClubJersey;

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

                int id = Integer.parseInt(teamJson.optString("idTeam", null));
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



    public static List<ClubJersey> mapJsonToClubJersey(String jsonString, String searchTerm) {
        List<ClubJersey> clubJerseys = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray teamsArray = jsonObject.getJSONArray("teams");

            for (int i = 0; i < teamsArray.length(); i++) {
                JSONObject teamJson = teamsArray.getJSONObject(i);

                String id = teamJson.optString("idTeam", null);
                String name = teamJson.optString("strTeam", null);
                String alternateName = teamJson.optString("strTeamAlternate", null);
                String shortName = teamJson.optString("strTeamShort", null);

                // Case-insensitive match
                if ((name != null && name.toLowerCase().contains(searchTerm.toLowerCase())) ||
                        (alternateName != null && alternateName.toLowerCase().contains(searchTerm.toLowerCase())) ||
                        (shortName != null && shortName.toLowerCase().contains(searchTerm.toLowerCase()))) {

                    ClubJersey clubJersey = new ClubJersey(id, name);
                    clubJerseys.add(clubJersey);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clubJerseys;
    }

    public static List<String> mapJsonToJerseyList(String jsonString) {
        List<String> jerseyUrls = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            JSONArray equipmentArray = jsonObject.getJSONArray("equipment");
            for (int i = 0; i < equipmentArray.length(); i++) {
                JSONObject equipment = equipmentArray.getJSONObject(i);

                // Extract season and URL
                String season = equipment.optString("strSeason", "");
                String jerseyUrl = equipment.optString("strEquipment", "");

                // Check if the season is within the latest two seasons
                if ((season.equals("2022-2023") || season.equals("2023-2024")) && !jerseyUrl.isEmpty()) {
                    jerseyUrls.add(jerseyUrl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jerseyUrls;
    }


}
