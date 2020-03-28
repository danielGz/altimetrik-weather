package com.altimetik.api.weather.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.altimetik.api.weather.domain.ForecastInfo;

@SpringBootTest
public class ForecastServiceTest {
	
	@Autowired
	ForecastService service;
	private static Double lat;
	private static Double longi;
	
	@BeforeAll
	public static void setup() {
		lat=ThreadLocalRandom.current().nextDouble(-90,90);
		longi=ThreadLocalRandom.current().nextDouble(-180,80);
	}
	
	@Test
	public void getNow() {
		
		ForecastInfo result=service.getForecast(lat, longi);
		
		assertNotNull(result);
	}
	
	@Test
	public void getAYearAgo() {		
		LocalDateTime time=LocalDateTime.now().minusMonths(12);
		ZoneId zoneId = ZoneId.systemDefault(); 
		long epoch = time.atZone(zoneId).toEpochSecond();
		
		ForecastInfo forecastYearAgo=service.getForecast(lat, longi,epoch);
		
		assertNotNull(forecastYearAgo);
	}

}
