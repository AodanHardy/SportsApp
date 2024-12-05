package com.example.sportsapp.API;

import static com.example.sportsapp.Utils.Constants.ALL_TEAMS_IN_LEAGUE_ENDPOINT;
import static com.example.sportsapp.Utils.Constants.EQUIPMENT_ENDPOINT;
import static com.example.sportsapp.Utils.Constants.SPORTS_API_URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Sports api client.
 */
public class SportsApiClient {
    private final ExecutorService executorService;

    /**
     * Instantiates a new Sports api client.
     */
    public SportsApiClient() {
        this.executorService = Executors.newSingleThreadExecutor();
    }

    /**
     * The interface Api callback.
     */
// Callback interface for async responses
    public interface ApiCallback {
        /**
         * On success.
         *
         * @param result the result
         */
        void onSuccess(String result);

        /**
         * On error.
         *
         * @param e the e
         */
        void onError(Exception e);
    }

    /**
     * Take a league name and return all clubs in it.
     *
     * @param league   the league
     * @param callback the callback
     */
// Get all teams by league
    public void getAllTeamsByLeague(String league, ApiCallback callback) {
        executorService.execute(() -> {
            try {
                String url = SPORTS_API_URL + ALL_TEAMS_IN_LEAGUE_ENDPOINT + URLEncoder.encode(league, "UTF-8");
                String response = sendGetRequest(url);
                callback.onSuccess(response);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }

    /**
     * Take a club name and return all equipment for it.
     *
     * @param clubId   the club id
     * @param callback the callback
     */
    public void getJerseysForClub(String clubId, ApiCallback callback) {
        executorService.execute(() -> {
            try {
                String url = SPORTS_API_URL + EQUIPMENT_ENDPOINT + clubId;
                String response = sendGetRequest(url);
                callback.onSuccess(response);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }

    // method is used to send HTTP requests 
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
}
