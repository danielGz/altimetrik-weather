package com.altimetik.api.weather.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetik.api.weather.domain.Forecast;
import com.altimetik.api.weather.domain.ForecastInfo;
import com.altimetik.api.weather.services.ForecastService;

@RestController
public class ForecastController {
	
	@Autowired
	ForecastService svc;
	
	@GetMapping(value="/forecast")
	@CrossOrigin
	public List<ForecastInfo> getForeCast(@RequestParam Double lat, @RequestParam(name="long") Double longi){
		
		LocalDateTime time=LocalDateTime.now().minusMonths(12);
		ZoneId zoneId = ZoneId.systemDefault(); 
		long epoch = time.atZone(zoneId).toEpochSecond();
		ForecastInfo forecastNow=svc.getForecast(lat, longi);
		ForecastInfo forecastYearAgo=svc.getForecast(lat, longi,epoch);
		
		ArrayList<ForecastInfo> result = new ArrayList<ForecastInfo>(
			      Arrays.asList(forecastNow,forecastYearAgo));
		
		return result;
	}

}
