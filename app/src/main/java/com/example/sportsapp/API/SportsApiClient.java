package com.example.sportsapp.API;

import static com.example.sportsapp.Utils.Constants.SPORTS_API_URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SportsApiClient {

    // Method to get all leagues by country
    public String getAllLeaguesByCountry(String country) {
        try {
            String endpoint = "search_all_leagues.php";
            String url = SPORTS_API_URL + endpoint + "?c=" + URLEncoder.encode(country, "UTF-8") + "&s=Soccer";
            return sendGetRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // get details of a club
    public String getClub(String club) {
        try {
            String endpoint = "searchteams.php";
            String url = SPORTS_API_URL + endpoint + "?t=" + URLEncoder.encode(club, "UTF-8");
            return sendGetRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // get all teams by league
    public String getAllTeamsByLeague(String league) {
        try {
            String endpoint = "search_all_teams.php";
            String url = SPORTS_API_URL + endpoint + "?l=" + URLEncoder.encode(league, "UTF-8");
            return sendGetRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // send GET requests
    private String sendGetRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new Exception("Failed to fetch data: HTTP error code " + responseCode);
        }
    }

}

