import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainPageComponent} from './Components/MainPageSections/main-page/main-page.component';
import {ShortenSectionComponent} from './Components/MainPageSections/shorten-section/shorten-section.component';
import {AuthGuardService} from './Services/Iam-Services/auth-guard.service';

const routes: Routes = [
  {
    path: 'main',
    component: MainPageComponent,
    canActivate: [ AuthGuardService ],
    data: { roles: ['User'] }
  },
  {
    path: 'shorten',
    component: ShortenSectionComponent,
    canActivate: [ AuthGuardService ],
    data: { roles: ['User'] }
  },
  {
    path: '',
    redirectTo: '/main',
    pathMatch: 'full',
    canActivate: [ AuthGuardService ],
    data: { roles: ['User'] }
    },
  {
    path: '**',
    component: MainPageComponent,
    canActivate: [ AuthGuardService ],
    data: { roles: ['User'] }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})

export class AppRoutingModule { }
