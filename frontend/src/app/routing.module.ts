import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {HomeComponent} from "./home/home.component";
import {QrcodePageComponent} from "./qrcode-page/qrcode-page.component";

const routes: Routes = [
  {path: '', component: LandingPageComponent},
  {path: 'home', component: HomeComponent},
  {path: 'scan', component: QrcodePageComponent}
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class RoutingModule {
}
