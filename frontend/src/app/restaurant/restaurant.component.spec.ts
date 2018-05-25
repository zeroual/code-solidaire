import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantComponent } from './restaurant.component';
import {MatCardModule} from "@angular/material";

describe('RestaurantComponent', () => {
  let component: RestaurantComponent;
  let fixture: ComponentFixture<RestaurantComponent>;
  let element:HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantComponent ],
      imports: [MatCardModule]
    })
    .compileComponents().then(()=>{
      fixture = TestBed.createComponent(RestaurantComponent);
      component = fixture.componentInstance;
      element = fixture.debugElement.nativeElement;
    });
  }));

  it('should display restaurant name', async(() => {
    component.restaurant = {
      id:'1',
      name:'name',
      lat: 0,
      lng: 0,
      photos:[],
      photo:'photo'
    };
    fixture.detectChanges();
    const restaurantName=element.querySelector('.restaurant-name').textContent.trim();
    expect(restaurantName).toContain('name');
  }));
});
