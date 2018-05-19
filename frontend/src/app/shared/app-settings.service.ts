import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppSettings {

  public googlePlacePhotoUrl = 'https://maps.googleapis.com/maps/api/place/photo';
  public googleMapsKey = 'AIzaSyBvLjHOMjmRVWELPcxI-YJ43rGJk2-cw2w';

  constructor() {
  }
}
