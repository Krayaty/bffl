import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './StartUpComponents/login/login.component';
import {MainPageComponent} from './MainPageSections/main-page/main-page.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'main', component: MainPageComponent },
  { path: '',   redirectTo: '/main', pathMatch: 'full' },
  { path: '**', component: MainPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
