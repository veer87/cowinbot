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
        headers.set("accept", "application/json");
        headers.set("Accept-Language", "hi_IN");


        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);

       // System.out.println(response.getBody());

    }

    public static ResponseEntity<String> getFindByPin(String pincode, String date) {
        if (pincode == null || date == null) return null;
        StringBuilder uri = new StringBuilder("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin");
        uri.append("?");
        uri.append(queryParams("pincode", pincode));
        uri.append("&").append(queryParams("date", date));

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Accept-Language", "hi_IN");


        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(uri.toString() + " headers " + headers.toString());
        return restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);

        // System.out.println(response.getBody());

    }

    private static String queryParams(String fieldName, String val) {
        return fieldName + "=" + val;
    }
}
