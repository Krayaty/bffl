import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './Components/StartUpComponents/login/login.component';
import {MainPageComponent} from './Components/MainPageSections/main-page/main-page.component';
import {ShortenSectionComponent} from './Components/MainPageSections/shorten-section/shorten-section.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'main', component: MainPageComponent },
  { path: 'shorten', component: ShortenSectionComponent },
  { path: '',   redirectTo: '/main', pathMatch: 'full' },
  { path: '**', component: MainPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})

export class AppRoutingModule { }
