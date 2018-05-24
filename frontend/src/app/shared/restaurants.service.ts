import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/internal/operators';
import {AppSettings} from './app-settings.service';
import {Restaurant} from "./Restaurant";

@Injectable()
export class RestaurantsService {

  private readonly googlePlacePhotoUrl: string;
  private readonly googleMapsKey: string;

  constructor(private httpClient: HttpClient, appSetting: AppSettings) {
    this.googlePlacePhotoUrl = appSetting.googlePlacePhotoUrl;
    this.googleMapsKey = appSetting.googleMapsKey;
  }

  public getNearbyRestaurants(): Promise<Restaurant[]> {
    return this.httpClient.get('/api/v1/restaurants').pipe(map(r => this.mapToRestaurant(r))).toPromise();
  }

  private mapToRestaurant(restaurants: any): Restaurant[] {
    return restaurants.map(restaurant => {
      let photos = restaurant.photosReference.map(photo => this.buildUrl(photo));
      return {
        id: restaurant.id,
        name: restaurant.name,
        lat: restaurant.location.lat,
        lng: restaurant.location.lng,
        photos: photos,
        photo: photos[0]
      }
    });
  }

  private buildUrl(photo: string): string {
    return this.googlePlacePhotoUrl + '?maxwidth=400&photoreference=' + photo + '&key=' + this.googleMapsKey;
  }

  public rewardMeal(restaurantId: string ): Promise<any> {
    return this.httpClient
      .post('/api/v1/reward', {'restaurantId': restaurantId})
      .toPromise();
  }

}
