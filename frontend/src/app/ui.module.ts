import {NgModule} from '@angular/core';
import {
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatProgressSpinnerModule,
  MatSidenavModule,
  MatToolbarModule
} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";
import {BrowserModule} from "@angular/platform-browser";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

const DEPENDENCIES = [
  BrowserModule,
  FlexLayoutModule,
  BrowserAnimationsModule,
  MatButtonModule,
  MatCardModule,
  MatSidenavModule,
  MatToolbarModule,
  MatIconModule,
  MatProgressSpinnerModule
];

@NgModule({
  imports: [DEPENDENCIES],
  exports: [DEPENDENCIES]
})
export class UiModule {
}
