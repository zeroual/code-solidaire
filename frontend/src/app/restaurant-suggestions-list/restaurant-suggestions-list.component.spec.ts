import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RestaurantSuggestionsListComponent} from './restaurant-suggestions-list.component';
import {RestaurantComponent} from "../restaurant/restaurant.component";
import {UiModule} from "../ui.module";

describe('RestaurantSuggestionsListComponent', () => {
  let component: RestaurantSuggestionsListComponent;
  let fixture: ComponentFixture<RestaurantSuggestionsListComponent>;
  let element: HTMLElement;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [UiModule],
      declarations: [RestaurantSuggestionsListComponent, RestaurantComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantSuggestionsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    element = fixture.debugElement.nativeElement;

  });

  it('should create componenté', () => {
    expect(component).toBeTruthy();
  });
  it('should display restaurant suggestions', () => {
    component.restaurants = [
      {id: "1", lng: 0, lat: 0, name: "opera", photo: "opera.png", photos: []},
      {id: "2", lng: 0, lat: 0, name: "atsu atsu", photo: "atsu.png", photos: []}
    ];
    fixture.detectChanges();
    const displayedRestaurantCount = element.querySelectorAll('app-restaurant').length;
    expect(displayedRestaurantCount).toEqual(2);

  })
});
