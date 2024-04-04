package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.URL;


public class TimetableScraper {
    public static void main(String[] args) {
        try {
            // URL of the webpage that returns JSON data
            String url = "https://win-nerkech-api.azurewebsites.net/api/groups/ING-A1-04/";

            // Create URL object
            URL apiUrl = new URL(url);

            // Create HttpURLConnection
            HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get the response code
            int responseCode = conn.getResponseCode();

            // Check if the response code is 200 (OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Create BufferedReader to read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                // Read the response line by line
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                    response.append("\n");
                }

                // Close the reader
                reader.close();

                // Print the JSON response
                System.out.println(response.toString());
            } else {
                System.out.println("Failed to fetch JSON data. Response code: " + responseCode);
            }

            // Disconnect the HttpURLConnection
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


