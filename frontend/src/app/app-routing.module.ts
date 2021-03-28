import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainPageComponent} from './Components/MainPageSections/main-page/main-page.component';
import {ShortenSectionComponent} from './Components/MainPageSections/shorten-section/shorten-section.component';
import {AuthGuardService} from './Services/Iam-Services/auth-guard.service';
import {environment} from '../environments/environment';

const routes: Routes = [
  {
    path: 'main',
    component: MainPageComponent,
    canActivate: [ AuthGuardService ],
    data: { roles: [ environment.idp.roles.user ] }
  },
  {
    path: 'shorten',
    component: ShortenSectionComponent,
    canActivate: [ AuthGuardService ],
    data: { roles: [ environment.idp.roles.user ] }
  },
  {
    path: '',
    redirectTo: '/main',
    pathMatch: 'full',
    canActivate: [ AuthGuardService ],
    data: { roles: [ environment.idp.roles.user ] }
  },
  {
    path: '**',
    component: MainPageComponent,
    canActivate: [ AuthGuardService ],
    data: { roles: [ environment.idp.roles.user ] }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule],
  providers: [AuthGuardService]
})

export class AppRoutingModule { }
