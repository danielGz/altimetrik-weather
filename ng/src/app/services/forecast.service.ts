import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ForecastService {

  constructor(private http: HttpClient) { }

  getForecast(lat:Number,long:Number){
    const url = `http://localhost:8080/forecast?lat=${lat}&long=${long}`;
    return this.http.get(url);
  }
}
