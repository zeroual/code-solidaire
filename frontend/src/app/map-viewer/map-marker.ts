import {} from "@types/googlemaps"

export class MapMarker {

  private marker: google.maps.Marker;

  constructor(private lat: number, private lng: number) {
    this.marker = new google.maps.Marker({
      position: {lat: this.lat, lng: this.lng}
    });
  }

  getLat(): number {
    return this.lat;
  }

  getLng(): number {
    return this.lng;
  }

  attachToMap(map: google.maps.Map) {
    this.marker.setMap(map);
  }

}
