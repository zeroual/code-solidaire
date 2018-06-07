import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {RestaurantsService} from "../shared/restaurants.service";

@Component({
  selector: 'app-qrcode-page',
  templateUrl: './qrcode-page.component.html',
  styleUrls: ['./qrcode-page.component.scss']
})
export class QrcodePageComponent implements OnInit {

  public qrCodeValue = '';
  public hideProgressBar: boolean = true;
  @ViewChild('buttonValidate', {read: ElementRef}) private buttonValidate: any;

  constructor(private restaurantService: RestaurantsService) { }

  ngOnInit() {
  }

  public updateQrCodeValue(event) {
    this.qrCodeValue = event;
  }

  public validateQrcode(): void {
    this.hideProgressBar = false;
    this.restaurantService
      .rewardMeal(this.qrCodeValue)
      .then(result => {
        this.buttonValidate.nativeElement.disabled = true;
        setTimeout(() => {this.hideProgressBar=true} ,500);
      });
  }

}
