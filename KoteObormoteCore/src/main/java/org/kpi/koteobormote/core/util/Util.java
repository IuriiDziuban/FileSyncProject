package org.kpi.koteobormote.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Util {
    
    private Util() {
        
    }

    public static String retrieveMessage() {
        try {
            URL url = new URL("http://kote-obormote.appspot.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            StringBuilder outputBuilder = new StringBuilder();
            while ((output = br.readLine()) != null) {
                outputBuilder.append(output);
            }
            conn.disconnect();

            return outputBuilder.toString();
            

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
}
