import {TestBed} from '@angular/core/testing';

import {RestaurantsService} from './restaurants.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {AppSettings} from './app-settings.service';

describe('RestaurantsService', () => {
  let httpBackend: HttpTestingController;
  let restaurantService: RestaurantsService;
  const mockAppSettings = {
    googlePlacePhotoUrl: 'mock_googlePlacePhotoUrl',
    googleMapsKey: 'mock_googleMapsKey'
  };
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [RestaurantsService, {provide: AppSettings, useValue: mockAppSettings}]
    });
    httpBackend = TestBed.get(HttpTestingController);
    restaurantService = TestBed.get(RestaurantsService);
  });

  it('should request backend to get nearby restaurants', () => {

    let photoReference = 'reference1';
    const expectedResponse = [
      {
        'id': 'id',
        'name': 'name',
        'location': {
          'lat': 0,
          'lng': 0,
        },
        'photosReference': [photoReference],
      }
    ];

    restaurantService.getNearbyRestaurants().then(restaurants => {

      let googlePlacePhotoUrl = mockAppSettings.googlePlacePhotoUrl;
      let googleMapsKey = mockAppSettings.googleMapsKey;
      const realUrlPhoto = googlePlacePhotoUrl + '?maxwidth=400&photoreference=' + photoReference + '&key=' + googleMapsKey;

      expect(restaurants).toEqual([{
        id: 'id',
        name: 'name',
        lat: 0,
        lng: 0,
        photos: [realUrlPhoto],
        photo: realUrlPhoto
      }]);
    });
    httpBackend.expectOne('/api/v1/restaurants').flush(expectedResponse);

  });
});
