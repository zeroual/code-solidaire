import { Injectable } from '@angular/core';
import {Observable} from "rxjs/index";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http: HttpClient) { }

  public getNearbyRestaurants(): Observable<any> {
    // return this.http.get("/restaurants");
    return this.http.get("/api/v1/restaurants");
  }
}
