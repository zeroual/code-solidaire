import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ScannerComponent} from './scanner.component';
import {CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {RestaurantsService} from "../shared/restaurants.service";
import {NgQrScannerModule} from "angular2-qrscanner";

describe('ScannerComponent', () => {
  let component: ScannerComponent;
  let fixture: ComponentFixture<ScannerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [NgQrScannerModule],
      declarations: [ ScannerComponent ],
      providers: [RestaurantsService],
      schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
