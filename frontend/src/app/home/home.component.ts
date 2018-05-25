import {Component, OnInit} from '@angular/core';
import {RestaurantsService} from '../shared/restaurants.service';
import {Restaurant} from "../shared/Restaurant";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public restaurants: Restaurant[] = [];

  constructor(private restaurantsService: RestaurantsService) {
  }

  ngOnInit() {
    this.restaurantsService.getNearbyRestaurants()
      .then(restaurants => this.restaurants = restaurants);
  }

}
