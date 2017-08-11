package com.app.restaurant.brownleaf.manager;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mobilecoe-imac6 on 19/10/16.
 */
public class HttpManager {

    public static String getResponseFromInputStream(InputStream in) {
        String text = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            text = sb.toString();
        } catch (Exception ex) {

        } finally {
            try {

                in.close();
            } catch (Exception ex) {
            }
        }
        return text;
    }

    public static String getResponse(HttpResponse response) {
        String text = "";
        try {
            text = getResponseFromInputStream(response.getEntity().getContent());
        } catch (Exception ex) {
        }
        return text;
    }
}
