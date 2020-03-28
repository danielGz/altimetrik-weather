package com.altimetik.api.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	
	String date;
	long time;
	double temperature;
	long sunriseTime;
	long sunsetTime;
	double temperatureHigh;
	long temperatureHighTime;
	double temperatureLow;
	long temperatureLowTime;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public long getSunriseTime() {
		return sunriseTime;
	}
	public void setSunriseTime(long sunriseTime) {
		this.sunriseTime = sunriseTime;
	}
	public long getSunsetTime() {
		return sunsetTime;
	}
	public void setSunsetTime(long sunsetTime) {
		this.sunsetTime = sunsetTime;
	}
	public double getTemperatureHigh() {
		return temperatureHigh;
	}
	public void setTemperatureHigh(double temperatureHigh) {
		this.temperatureHigh = temperatureHigh;
	}
	public long getTemperatureHighTime() {
		return temperatureHighTime;
	}
	public void setTemperatureHighTime(long temperatureHighTime) {
		this.temperatureHighTime = temperatureHighTime;
	}
	public double getTemperatureLow() {
		return temperatureLow;
	}
	public void setTemperatureLow(double temperatureLow) {
		this.temperatureLow = temperatureLow;
	}
	public long getTemperatureLowTime() {
		return temperatureLowTime;
	}
	public void setTemperatureLowTime(long temperatureLowTime) {
		this.temperatureLowTime = temperatureLowTime;
	}

}
