package org.covid19.india.CowinBot.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class District {
	
	@JsonProperty("district_id")
	private String districtId;
	
	@JsonProperty("district_name")
	private String districtName;

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", districtName=" + districtName + "]";
	}
	
	
	
	
	

}
