package com.altimetik.api.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WeatherApplication {
	
	@Value("${api.key}")
	String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);		
	}
	
	@Bean
	WebClient getForecastClient() {
		return WebClient.create("https://api.darksky.net/forecast/"+apiKey+"/");
	}

}
