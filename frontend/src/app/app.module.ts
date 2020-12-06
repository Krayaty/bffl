import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
//import { TopBarComponent } from './top-bar/top-bar.component';
import { ShortenSectionComponent } from './MainPageSections/shorten-section/shorten-section.component';
import { UrlManagerSectionComponent } from './MainPageSections/url-manager-section/url-manager-section.component';
import { FormsModule } from '@angular/forms';
import {ViewUrlPageComponent} from './MainPageSections/view-url-page/view-url-page.component';
import { LoginComponent } from './StartUpComponents/login/login.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ShortenSectionComponent,
    UrlManagerSectionComponent,
    LoginComponent
  ],

  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
