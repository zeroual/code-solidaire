import { Component, OnInit } from '@angular/core';
import {RestaurantService} from "../../shared/services/restaurant.service";
import {Restaurant} from "../../shared/models/restaurant";
import {Location} from "../../shared/models/location";

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  public result: string = '';
  public restaurants: Restaurant[];

  constructor(private rs: RestaurantService) {
  }

  ngOnInit() {
    // this.rs.getNearbyRestaurants()
    //   .subscribe(result => {
    //     this.result = JSON.stringify(result);
    //   });
    this.rs.getNearbyRestaurants().subscribe( result =>
      this.restaurants = result.map( r =>  new Restaurant(r.name, r.address, new Location(r.location.lat, r.location.lng), r.photosReference) ) )
  }

}
