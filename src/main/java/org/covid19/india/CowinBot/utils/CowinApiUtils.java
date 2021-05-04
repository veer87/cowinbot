package org.covid19.india.CowinBot.utils;

import org.covid19.india.CowinBot.service.CowinApi;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CowinApiUtils {

    public static boolean isValidApiParams(String[] params) {
        if (params.length > 1) {
            String q1 = params[1];
            String q2 = "";
            if (params.length > 2) q2 = params[2];
        }
        return false;
    }

    public static String[] validateAndSetApiParams(String[] params) {
        if (params.length > 1) {
            String q1 = params[1];
            String q2 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            if (params.length > 2) {
                q2 = params[2];
            }
            return new String[]{q1, q2};

        }
        return null;
    }

    public static String callCowinQueryApi(String[] tokens) {
        String[] params = validateAndSetApiParams(tokens);
        ResponseEntity<String> response = CowinApi.getFindByPin(params[0], params[1]);
        if (response.getStatusCode() == HttpStatus.OK) {
            return getFormatted(response.getBody());
        }
        return null;
    }

    private static String getFormatted(String s) {
        StringBuilder response = new StringBuilder();
        JSONParser jsonParser = new JSONParser();

        JSONArray arr;

        try {
            arr = (JSONArray)jsonParser.parse("sessions");
        } catch (ParseException e) {
            //log error
            e.printStackTrace();
            return response.toString();
        }



        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            addField(obj,response, "center_id");
            addField(obj, response, "name");
            addField(obj, response, "address");
            addField(obj, response, "available_capacity");
            addField(obj, response, "min_age_limit");
            response.append("\n").append("--------------------");
        }

        return response.toString();
    }

    private static void addField(JSONObject obj, StringBuilder sb, String key) {
        if (obj.has(key)) {
            sb.append(key).append(": ").append(obj.get("name")).append("\n");
        }
    }


}
