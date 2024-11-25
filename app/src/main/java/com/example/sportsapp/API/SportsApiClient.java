package com.example.sportsapp.API;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SportsApiClient {

    private static final String SPORTS_API_URL = "https://www.thesportsdb.com/api/v1/json/3/";
    private final ExecutorService executorService;

    public SportsApiClient() {
        this.executorService = Executors.newSingleThreadExecutor();
    }

    // Callback interface for async responses
    public interface ApiCallback {
        void onSuccess(String result);
        void onError(Exception e);
    }

    // Get all leagues by country
    public void getAllLeaguesByCountry(String country, ApiCallback callback) {
        executorService.execute(() -> {
            try {
                String endpoint = "search_all_leagues.php";
                String url = SPORTS_API_URL + endpoint + "?c=" + URLEncoder.encode(country, "UTF-8") + "&s=Soccer";
                String response = sendGetRequest(url);
                callback.onSuccess(response);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }

    // Get details of a club
    public void getClub(String club, ApiCallback callback) {
        executorService.execute(() -> {
            try {
                String endpoint = "searchteams.php";
                String url = SPORTS_API_URL + endpoint + "?t=" + URLEncoder.encode(club, "UTF-8");
                String response = sendGetRequest(url);
                callback.onSuccess(response);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }

    // Get all teams by league
    public void getAllTeamsByLeague(String league, ApiCallback callback) {
        executorService.execute(() -> {
            try {
                String endpoint = "search_all_teams.php";
                String url = SPORTS_API_URL + endpoint + "?l=" + URLEncoder.encode(league, "UTF-8");
                String response = sendGetRequest(url);
                callback.onSuccess(response);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }

    // Send GET requests
    private String sendGetRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new Exception("Failed to fetch data: HTTP error code " + responseCode);
        }
    }

    // Shutdown executor service
    public void shutdown() {
        executorService.shutdown();
    }
}
