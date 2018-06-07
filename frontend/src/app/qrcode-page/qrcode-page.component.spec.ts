import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QrcodePageComponent } from './qrcode-page.component';
import {CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {RestaurantsService} from "../shared/restaurants.service";
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('QrcodePageComponent', () => {
  let component: QrcodePageComponent;
  let fixture: ComponentFixture<QrcodePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [ QrcodePageComponent ],
      providers: [RestaurantsService],
      schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QrcodePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
