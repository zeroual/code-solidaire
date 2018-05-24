import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LandingPageComponent} from './landing-page/landing-page.component';
import {RoutingModule} from "./routing.module";
import {HomeComponent} from './home/home.component';
import {RestaurantComponent} from './restaurant/restaurant.component';
import {HttpClientModule} from '@angular/common/http';
import {RestaurantsService} from "./shared/restaurants.service";
import {UiModule} from "./ui.module";
import {ScannerComponent} from "./scanner/scanner.component";
import {QrcodePageComponent} from "./qrcode-page/qrcode-page.component";
import {RestaurantSuggestionsListComponent} from "./restaurant-suggestions-list/restaurant-suggestions-list.component";
import {RestaurantSuggestionsMapComponent} from "./restaurant-suggestions-map/restaurant-suggestions-map.component";
import {MapViewerComponent} from "./map-viewer/map-viewer.component";
import {NgQrScannerModule} from "angular2-qrscanner";
@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    HomeComponent,
    RestaurantComponent,
    MapViewerComponent,
    RestaurantSuggestionsMapComponent,
    RestaurantSuggestionsListComponent,
    QrcodePageComponent,
    ScannerComponent
  ],
  imports: [
    RoutingModule,
    UiModule,
    HttpClientModule,
    NgQrScannerModule,
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers: [RestaurantsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
