package com.altimetik.api.weather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.altimetik.api.weather.domain.Forecast;
import com.altimetik.api.weather.domain.ForecastInfo;

import reactor.core.publisher.Mono;

@Service
public class ForecastService {
	
	private WebClient client;

	public ForecastService(@Autowired WebClient forecastClient) {
		this.client=forecastClient;
	}

	public ForecastInfo getForecast(Double lat, Double longi) {
		client.method(HttpMethod.GET);
		client.get();
		Mono<ClientResponse> clientResponse = client.get().uri(lat+","+longi).exchange();
		ForecastInfo forecastInfo=clientResponse.flatMap(response -> response.bodyToMono(ForecastInfo.class)).block();
		return forecastInfo;
	}
	
	public ForecastInfo getForecast(Double lat, Double longi, long timestamp) {
		client.method(HttpMethod.GET);
		client.get();
		Mono<ClientResponse> clientResponse = client.get().uri(lat+","+longi+","+timestamp).exchange();
		ForecastInfo forecastInfo=clientResponse.flatMap(response -> response.bodyToMono(ForecastInfo.class)).block();
		return forecastInfo;
	}

}
