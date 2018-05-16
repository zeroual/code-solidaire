import {Component, OnInit} from '@angular/core';
import {RestaurantService} from "./services/restaurant.service";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'app';

  constructor( private restaurantService: RestaurantService ) {
    console.log(">>>>>>>>>", isNullOrUndefined(this.restaurantService))

  }

  ngOnInit(): void {
    this.restaurantService.getRestaurant()
      .subscribe(result => console.log("========", result));
  }

}
