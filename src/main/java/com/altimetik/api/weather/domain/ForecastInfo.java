package com.altimetik.api.weather.domain;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ForecastInfo {
	
	Long latitude;
	Long longitude;
	
	List<Forecast> daily;
	
	@JsonProperty("daily")
	public void setDailyData(Map<String,Object> daily) {		
		ObjectMapper mapper=new ObjectMapper();
		List<Forecast> forecasts=mapper.convertValue(daily.get("data"), new TypeReference<List<Forecast>>() { });
		this.daily=forecasts;
	}

	public List<Forecast> getDaily() {
		return (List<Forecast>)daily;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
	
}
