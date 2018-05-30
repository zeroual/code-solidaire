import {Component, Input, OnInit} from '@angular/core';
import {RestaurantsService} from "../shared/restaurants.service";
import {Restaurant} from "../shared/Restaurant";

@Component({
  selector: 'app-restaurant-suggestions-list',
  templateUrl: './restaurant-suggestions-list.component.html',
  styleUrls: ['./restaurant-suggestions-list.component.css']
})
export class RestaurantSuggestionsListComponent implements OnInit {

  @Input()
  public restaurants: Restaurant[] = [];

  constructor() {
  }

  ngOnInit() {

  }
}
