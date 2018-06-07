import {MapMarker} from "./map-marker";
import {} from '@types/googlemaps';

export class GoogleMaps {

  public map: google.maps.Map;
  private markers: MapMarker[];

  constructor(private root: HTMLElement) {
    const properties = {
      center: new google.maps.LatLng(48.8661735, 2.3337291),
      zoom: 12,
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      streetViewControl: false,
      mapTypeControl: false
    };
    this.map = new google.maps.Map(root, properties);
  }

  setMarkers(markers: MapMarker[]): void {
    this.markers = markers;
    markers.forEach(marker => marker.attachToMap(this.map));
  }

  zoomOnMarkers(): void {
    if (this.markers.length == 0) {
      return;
    }
    const bounds = new google.maps.LatLngBounds();
    this.markers.forEach(marker => bounds.extend({lat: marker.getLat(), lng: marker.getLng()}));
    this.map.fitBounds(bounds, 100);
  }

}
