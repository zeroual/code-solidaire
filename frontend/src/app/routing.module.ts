import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path: '', component: LandingPageComponent},
  {path: 'home', component: HomeComponent}
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
