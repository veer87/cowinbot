package org.covid19.india.CowinBot.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccinationCentre {
	
	private String center_id;
	private String name;
	private String address;
	private String state_name;
	private String district_name;
	private String pincode;
	private String from;
	private String to;
	
	@JsonProperty("lat")
	private String latitute;
	
	@JsonProperty("long")
	private String longitute;
	
	private String fee_type;
	private String session_id;
	private String date;
	private String available_capacity;
	private String fee;
	private String min_age_limit;
	private String vaccine;
	private List<String> slots;
	
	public String getCenter_id() {
		return center_id;
	}
	public void setCenter_id(String center_id) {
		this.center_id = center_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getLatitute() {
		return latitute;
	}
	public void setLatitute(String latitute) {
		this.latitute = latitute;
	}
	public String getLongitute() {
		return longitute;
	}
	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAvailable_capacity() {
		return available_capacity;
	}
	public void setAvailable_capacity(String available_capacity) {
		this.available_capacity = available_capacity;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getMin_age_limit() {
		return min_age_limit;
	}
	public void setMin_age_limit(String min_age_limit) {
		this.min_age_limit = min_age_limit;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public List<String> getSlots() {
		return slots;
	}
	public void setSlots(List<String> slots) {
		this.slots = slots;
	}
	
	@Override
	public String toString() {
		return "VaccinationCentre\nname=" + name + "\naddress=" + address + "\nstate_name=" + state_name
				+ "\ndistrict_name=" + district_name + "\npincode=" + pincode + "\nfrom=" + from + "\nto=" + to
				+ "\nlatitute=" + latitute + "\nlongitute=" + longitute + "\ndate=" + date + "\navailable_capacity="
				+ available_capacity + "\nslots=" + slots + "\n--------------------------\n";
	}
	

}
