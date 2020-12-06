import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './StartUpComponents/login/login.component';
import {MainPageComponent} from './MainPageSections/main-page/main-page.component';
import {ShortenSectionComponent} from './MainPageSections/shorten-section/shorten-section.component';
import {UrlManagerSectionComponent} from './MainPageSections/url-manager-section/url-manager-section.component';
import {ViewUrlPageComponent} from './MainPageSections/view-url-page/view-url-page.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'main', component: MainPageComponent },
  { path: 'shorten', component: ShortenSectionComponent },
  { path: 'manager', component: UrlManagerSectionComponent },
  { path: 'view', component: ViewUrlPageComponent },
  { path: '',   redirectTo: '/main', pathMatch: 'full' },
  { path: '**', component: MainPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
