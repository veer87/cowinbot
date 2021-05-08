package org.covid19.india.CowinBot.service;

import java.util.ArrayList;
import java.util.List;

import org.covid19.india.CowinBot.pojo.District;
import org.covid19.india.CowinBot.pojo.DistrictsWrapper;
import org.covid19.india.CowinBot.pojo.VaccinationCentre;
import org.covid19.india.CowinBot.pojo.VaccinationCentreWrapper;
import org.covid19.india.CowinBot.strategy.CustomComparatorBasedOnLocation;
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
    
    public  static List<VaccinationCentre> getAvailableVaccinationCentresBylocation(String userLatitute, String userLongitute, String stateId, String date){
    	
    	List<VaccinationCentre> vaccinationCentreList = getAllVaccinationCentresByState(stateId, date);
    	System.out.println(vaccinationCentreList);
    	
    	vaccinationCentreList.sort(new CustomComparatorBasedOnLocation(userLatitute,userLongitute));

    	return vaccinationCentreList;
    }
    
    public static List<VaccinationCentre> getAllVaccinationCentresByState(String stateId, String date) {
    	
    	ResponseEntity<DistrictsWrapper> response = getAllDitrictsByState(stateId);
    	DistrictsWrapper districtsResponse = response.getBody();
    	List<District> districts =  districtsResponse.getDistricts();
    	
    	System.out.println(districts);
    	
    	List<VaccinationCentre> vaccinationCentreList = new ArrayList<>();
    	
    	for(District district: districts) {
    		ResponseEntity<VaccinationCentreWrapper> vaccinationCentreWrapperResponse = getAllAvailableVaccinationCentresByDistrictAndDate(district.getDistrictId(),date);
            
    		vaccinationCentreList.addAll(vaccinationCentreWrapperResponse.getBody().getSessions());
            
    	}
    	
    	return vaccinationCentreList;
    	
    }
    
    public static ResponseEntity<DistrictsWrapper> getAllDitrictsByState(String stateId){
    	StringBuilder uri = new StringBuilder("https://cdn-api.co-vin.in/api/v2/admin/location/districts/");
        uri.append(stateId);
    

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept-Language", "hi_IN");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(uri.toString() + " headers " + headers.toString());

        ResponseEntity<DistrictsWrapper> responseEntity = null;
        try {
        	responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, DistrictsWrapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    	
    }
    
    public static ResponseEntity<VaccinationCentreWrapper> getAllAvailableVaccinationCentresByDistrictAndDate(String districtId, String date){
    	
    	StringBuilder uri = new StringBuilder("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict");
    	uri.append("?");
        uri.append(queryParams("district_id", districtId));
        uri.append("&").append(queryParams("date", date));
    

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept-Language", "hi_IN");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(uri.toString() + " headers " + headers.toString());

        ResponseEntity<VaccinationCentreWrapper> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, VaccinationCentreWrapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // TODO responseEntity is coming null sometimes... may be due to more requests per minute
        return responseEntity;
    	
    	
    }
    
    
    
    
    
}
