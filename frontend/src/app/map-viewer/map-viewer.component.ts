import {AfterViewInit, Component, Input, OnDestroy, ViewChild} from '@angular/core';
import {GoogleMaps} from "./google-maps";
import {MapMarker} from "./map-marker";
import {BehaviorSubject} from "rxjs/index";

@Component({
  selector: 'app-map-viewer',
  templateUrl: './map-viewer.component.html',
  styleUrls: ['./map-viewer.component.scss']
})
export class MapViewerComponent implements AfterViewInit, OnDestroy {

  private markersChanged: BehaviorSubject<MapMarker[]> = new BehaviorSubject<MapMarker[]>([]);

  @ViewChild('map') mapElement: any;

  private map: GoogleMaps;

  constructor() {
  }

  @Input()
  set markers(markers: MapMarker[]) {
    this.markersChanged.next(markers);
  }

  ngAfterViewInit(): void {
    this.map = new GoogleMaps(this.mapElement.nativeElement);
    this.markersChanged.subscribe(newMarkers => this.updateMarkers(newMarkers));
  }

  updateMarkers(markers: MapMarker[]) {
    this.map.setMarkers(markers);
    this.map.zoomOnMarkers();
  }

  ngOnDestroy(): void {
    this.markersChanged.unsubscribe();
  }


}
