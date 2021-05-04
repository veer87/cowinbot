package org.covid19.india.CowinBot.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CowinApi {

    public static ResponseEntity<String> getCalendarByPin(String pincode, String date) {
        if (pincode == null || date == null) return null;
        StringBuilder uri = new StringBuilder("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin");
        uri.append("?");
        uri.append(queryParams("pincode", pincode));
        uri.append("&").append(queryParams("date", date));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept-Language", "hi_IN");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;

       // System.out.println(response.getBody());

    }

    public static ResponseEntity<String> getFindByPin(String pincode, String date) {
        if (pincode == null || date == null) return null;
        StringBuilder uri = new StringBuilder("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin");
        uri.append("?");
        uri.append(queryParams("pincode", pincode));
        uri.append("&").append(queryParams("date", date));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept-Language", "hi_IN");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(uri.toString() + " headers " + headers.toString());

        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
        //
    }

    private static String queryParams(String fieldName, String val) {
        return fieldName + "=" + val;
    }
}
