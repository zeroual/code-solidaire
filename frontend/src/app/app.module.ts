import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LandingPageComponent} from './landing-page/landing-page.component';
import {RoutingModule} from "./routing.module";
import {HomeComponent} from './home/home.component';
import {RestaurantComponent} from './restaurant/restaurant.component';
import {HttpClientModule} from '@angular/common/http';
import {RestaurantsService} from "./shared/restaurants.service";
import {MapViewerComponent} from './map-viewer/map-viewer.component';
import {RestaurantSuggestionsMapComponent} from './restaurant-suggestions-map/restaurant-suggestions-map.component';
import {RestaurantSuggestionsListComponent} from './restaurant-suggestions-list/restaurant-suggestions-list.component';
import {UiModule} from "./ui.module";

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    HomeComponent,
    RestaurantComponent,
    MapViewerComponent,
    RestaurantSuggestionsMapComponent,
    RestaurantSuggestionsListComponent,
  ],
  imports: [
    RoutingModule,
    UiModule,
    HttpClientModule
  ],
  providers: [RestaurantsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
