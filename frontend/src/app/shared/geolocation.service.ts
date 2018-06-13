import { Injectable } from '@angular/core';
import { Coordinates } from './Coordinates';


@Injectable({
  providedIn: 'root'
})
export class GeolocationService {

  constructor() { }

  getCurrentPosition(): Promise<Coordinates>{
    if (navigator.geolocation) {
        let coord: Coordinates;
        let promise = new Promise<Coordinates>((resolve, reject) => {
          navigator.geolocation.getCurrentPosition((position) => {
            let crd = position.coords;
            coord = { latitude: crd.latitude, longitude: crd.longitude };
            resolve(coord);
          })
        });
        return promise;
    }else {
      throw new Error('Geolocaiton is not supported by this browser.');
    }
  }
}
