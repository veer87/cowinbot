package org.covid19.india.CowinBot.strategy;

import java.util.Comparator;

import org.covid19.india.CowinBot.pojo.VaccinationCentre;

public class CustomComparatorBasedOnLocation implements Comparator<VaccinationCentre> {
	
	String userLatitute;
	String userLongitude;
	
	private double distance(String fromLatString, String fromLonString, String toLatString, String toLonString) {
		
		double fromLat = Double.valueOf(fromLatString);
		double fromLon = Double.valueOf(fromLonString);
		double toLat = Double.valueOf(toLatString);
		double toLon = Double.valueOf(toLonString);
		
	    double radius = 6378137;   // approximate Earth radius, *in meters*
	    double deltaLat = toLat - fromLat;
	    double deltaLon = toLon - fromLon;
	    double angle = 2 * Math.asin( Math.sqrt(
	        Math.pow(Math.sin(deltaLat/2), 2) + 
	        Math.cos(fromLat) * Math.cos(toLat) * 
	        Math.pow(Math.sin(deltaLon/2), 2) ) );
	    return radius * angle;
	}
	

	public CustomComparatorBasedOnLocation(String userLatitute, String userLongitude) {
		super();
		this.userLatitute = userLatitute;
		this.userLongitude = userLongitude;
	}

	@Override
	public int compare(VaccinationCentre o1, VaccinationCentre o2) {
		int aDist = (int)Math.round(distance(o1.getLatitute(),o1.getLongitute(), this.userLatitute, this.userLongitude));
        int bDist = (int)Math.round(distance(o2.getLatitute(),o2.getLongitute(), this.userLatitute, this.userLongitude));
        return aDist - bDist;
	}

}
