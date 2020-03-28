import { Component, OnInit } from '@angular/core';
import {ForecastService} from '../../services/forecast.service';
import { ActivatedRoute } from '@angular/router';
import {Observable } from 'rxjs';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  forecasts:Observable<any>;
  lat:Number;
  long:Number;

  constructor(private svc:ForecastService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(params=>{this.forecasts=this.getForecasts(Number(params.get('lat')),Number(params.get('long')))});
  }

  getForecasts(lat:Number,long:Number):Observable<any>{
    return this.svc.getForecast(10,10);
  }

}
