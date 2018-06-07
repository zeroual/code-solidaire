import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {MapMarker} from "../map-viewer/map-marker";
import {Restaurant} from "../shared/Restaurant";
import {BehaviorSubject} from "rxjs/index";

@Component({
  selector: 'app-restaurant-suggestions-map',
  templateUrl: './restaurant-suggestions-map.component.html',
  styleUrls: ['./restaurant-suggestions-map.component.scss']
})
export class RestaurantSuggestionsMapComponent implements OnInit, OnDestroy {

  private restaurantsChanged = new BehaviorSubject<Restaurant[]>([]);
  public markers: MapMarker[] = [];

  @Input()
  set restaurants(restaurants: Restaurant[]) {
    this.restaurantsChanged.next(restaurants);
  }

  constructor() {
  }

  ngOnInit() {
    this.restaurantsChanged.subscribe(restaurants => {
        this.markers = restaurants.map(restaurant => new MapMarker(restaurant.lat, restaurant.lng));
      }
    );
  }

  ngOnDestroy(): void {
    this.restaurantsChanged.unsubscribe();
  }


}
