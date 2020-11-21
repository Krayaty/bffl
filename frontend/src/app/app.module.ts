import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { ShortenSectionComponent } from './MainPageSections/shorten-section/shorten-section.component';
import { UrlManagerSectionComponent } from './MainPageSections/url-manager-section/url-manager-section.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    ShortenSectionComponent,
    UrlManagerSectionComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
