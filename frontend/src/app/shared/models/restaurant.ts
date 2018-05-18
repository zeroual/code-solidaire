import {Location} from "./location";

export class Restaurant {

  constructor(
    public name: string,
    public adress: string,
    public location: Location,
    public photosReference: string[],
    public rating: number) {}

    public getImagesUrls(): string[] {
      let urls: string[] = [];
      this.photosReference.forEach( reference =>
        urls.push('https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=' + reference +
          '&key=AIzaSyBvLjHOMjmRVWELPcxI-YJ43rGJk2-cw2w')
      );
      return urls;
    }
}
