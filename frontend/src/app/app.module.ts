import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import {RoutingModule} from "./routing.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule, MatCardModule,MatToolbarModule} from "@angular/material";
import { HomeComponent } from './home/home.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import {HttpClientModule} from '@angular/common/http';
import {FlexLayoutModule} from "@angular/flex-layout";
import {RestaurantsService} from "./shared/restaurants.service";

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    HomeComponent,
    RestaurantComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatToolbarModule,
    HttpClientModule
  ],
  providers: [RestaurantsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
