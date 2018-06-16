import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RestaurantComponent} from './restaurant.component';
import {UiModule} from "../ui.module";
import {DurationFormatter} from "../shared/duration-formatter.pipe";
import {DistanceFormatter} from "../shared/distance-formatter.pipe";

describe('RestaurantComponent', () => {
  let component: RestaurantComponent;
  let fixture: ComponentFixture<RestaurantComponent>;
  let element: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [RestaurantComponent, DurationFormatter, DistanceFormatter],
      imports: [UiModule]
    })
      .compileComponents().then(() => {
      fixture = TestBed.createComponent(RestaurantComponent);
      component = fixture.componentInstance;
      element = fixture.debugElement.nativeElement;
    });
  }));

  it('should display restaurant name', () => {
    component.restaurant = {
      id: '1',
      name: 'name',
      lat: 0,
      lng: 0,
      photos: [],
      photo: 'photo',
      routeDuration: '3600',
      routeDistance: '70'
    };
    fixture.detectChanges();
    const restaurantName = element.querySelector('.restaurant-name').textContent.trim();
    expect(restaurantName).toContain('name');
  });
});
