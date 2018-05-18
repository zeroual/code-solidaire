import {Component, OnInit, ViewChild} from '@angular/core';
import {RestaurantService} from "../../shared/services/restaurant.service";
import {Restaurant} from "../../shared/models/restaurant";
import {Location} from "../../shared/models/location";
import {QrScannerComponent} from "angular2-qrscanner";

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  public restaurants: Restaurant[];
  @ViewChild(QrScannerComponent) qrScannerComponent: QrScannerComponent ;

  constructor(private rs: RestaurantService) {
  }

  ngOnInit() {
    this.rs.getNearbyRestaurants().subscribe( result =>
      this.restaurants = result.map( r =>  new Restaurant(r.name, r.address, new Location(r.location.lat, r.location.lng), r.photosReference, r.rating) ) )
    this.initQrCode();
  }


  initQrCode() {
    this.qrScannerComponent.getMediaDevices().then(devices => {
      console.log(devices);
      const videoDevices: MediaDeviceInfo[] = [];
      for (const device of devices) {
        if (device.kind.toString() === 'videoinput') {
          videoDevices.push(device);
        }
      }
      if (videoDevices.length > 0){
        let choosenDev;
        for (const dev of videoDevices){
          if (dev.label.includes('front') || dev.label.includes('Camera')){
            choosenDev = dev;
            break;
          }
        }
        if (choosenDev) {
          console.log("==========", choosenDev);
          this.qrScannerComponent.chooseCamera.next(choosenDev);
        } else {
          console.log("==========ELSE");
          this.qrScannerComponent.chooseCamera.next(videoDevices[0]);
        }
      }
    });

    this.qrScannerComponent.capturedQr.subscribe(result => {
      console.log(result);
    });
  }

}
