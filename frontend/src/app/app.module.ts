import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RestaurantService} from "./shared/services/restaurant.service";
import {HttpClientModule} from "@angular/common/http";
import {MatCardModule} from "@angular/material";
import {RestaurantsComponent} from "./components/restaurants/restaurants.component";

@NgModule({
  declarations: [
    AppComponent,
    RestaurantsComponent
  ],
  imports: [
    MatCardModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [RestaurantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
