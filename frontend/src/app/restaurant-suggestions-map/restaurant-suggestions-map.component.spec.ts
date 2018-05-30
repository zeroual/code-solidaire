import {async, ComponentFixture, ComponentFixtureAutoDetect, TestBed} from '@angular/core/testing';

import {RestaurantSuggestionsMapComponent} from './restaurant-suggestions-map.component';
import {CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA} from "@angular/core";

describe('RestaurantSuggestionsMapComponent', () => {
  let component: RestaurantSuggestionsMapComponent;
  let fixture: ComponentFixture<RestaurantSuggestionsMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [RestaurantSuggestionsMapComponent],
      providers: [
        {provide: ComponentFixtureAutoDetect, useValue: true}],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantSuggestionsMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
