import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {QrScannerComponent} from "angular2-qrscanner";

@Component({
  selector: 'app-scanner',
  templateUrl: './scanner.component.html',
  styleUrls: ['./scanner.component.css']
})
export class ScannerComponent implements OnInit {

  @ViewChild(QrScannerComponent) qrScannerComponent: QrScannerComponent;

  @Output('qrCode') public emitter = new EventEmitter();

  constructor() { }

  ngOnInit() {
    this.qrScannerComponent.getMediaDevices().then(devices => {
      console.log(devices);

      const videoDevices = devices.
          filter(device => device.kind.toString() === 'videoinput');

      let choosenDevice = videoDevices.
          filter(device => device.label.includes('front') || device.label.includes('Camera'))[0];

        if (choosenDevice) {
          this.qrScannerComponent.chooseCamera.next(choosenDevice);
        } else {
          this.qrScannerComponent.chooseCamera.next(videoDevices[0]);
        }
    });

    this.qrScannerComponent.capturedQr.subscribe(result => {
      this.emitter.emit(result);
    });
  }

}
