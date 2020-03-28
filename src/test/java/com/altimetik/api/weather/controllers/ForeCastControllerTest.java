package com.altimetik.api.weather.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.altimetik.api.weather.domain.Forecast;
import com.altimetik.api.weather.domain.ForecastInfo;
import com.altimetik.api.weather.services.ForecastService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ForeCastControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ForecastService forecastSvc;
	
	@Test
	public void getForecastOk() throws Exception {
		Double lat = ThreadLocalRandom.current().nextDouble(-90,90);
		Double longi = ThreadLocalRandom.current().nextDouble(-180,80);
		
		ForecastInfo foreCastInfo=new ForecastInfo();
		Forecast forecast=new Forecast();
		forecast.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		forecast.setSunriseTime(1585404060);
		forecast.setSunsetTime(1585449000);
		forecast.setTemperature(51.21);
		forecast.setTemperatureHigh(55.11);
		forecast.setTemperatureHighTime(1585433520);
		forecast.setTemperatureLow(50.47);
		forecast.setTemperatureLowTime(1585492500);
		forecast.setTime(1585404211);
		
		foreCastInfo.getDaily().add(forecast);
		
		when(forecastSvc.getForecast(lat,longi)).thenReturn(foreCastInfo);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/forecast?lat="+lat+"&long="+longi).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2))).andDo(print());
		
		
	}
	
	@Test
	public void getForecastError() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/forecast").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(400));	
		
	}

}
