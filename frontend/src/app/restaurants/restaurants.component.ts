import { Component, OnInit } from '@angular/core';
import {RestaurantService} from "../shared/services/restaurant.service";

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  public result: string = '';

  constructor(private rs: RestaurantService) {
  }

  ngOnInit() {
    this.rs.getNearbyRestaurants()
      .subscribe(result => {
        this.result = JSON.stringify(result);
        console.log(">>>>>>>", result);
      });
  }

}
