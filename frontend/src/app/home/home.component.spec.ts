import {async, ComponentFixture, ComponentFixtureAutoDetect, TestBed} from '@angular/core/testing';

import {HomeComponent} from './home.component';
import {RestaurantsService} from '../shared/restaurants.service';
import {Restaurant} from "../shared/Restaurant";
import {RestaurantComponent} from "../restaurant/restaurant.component";
import {MatCardModule} from "@angular/material";

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let element: HTMLElement;
  const restaurants: Restaurant[] = [{
    id: '1',
    name: '',
    lat: 23,
    lng: 2,
    photos: [],
    photo: ''
  }];
  const mockRestaurantService = {
    getNearbyRestaurants: jasmine.createSpy('getNearbyRestaurants').and.returnValue(Promise.resolve(restaurants))
  };

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HomeComponent, RestaurantComponent],
      imports: [MatCardModule],
      providers: [{provide: ComponentFixtureAutoDetect, useValue: true}]
    }).overrideComponent(HomeComponent, {
      set: {
        providers: [{provide: RestaurantsService, useValue: mockRestaurantService}]
      }
    }).compileComponents().then(() => {
      fixture = TestBed.createComponent(HomeComponent);
      component = fixture.componentInstance;
      element = fixture.debugElement.nativeElement;
      fixture.detectChanges();
    });
  }));

  it('should fetch and display all nearby restaurants', () => {
    const restaurantCount = element.querySelectorAll('app-restaurant').length;
    expect(restaurantCount).toEqual(1);
  });

});
