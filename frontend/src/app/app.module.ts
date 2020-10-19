import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { ShortenSectionComponent } from './MainPageSections/shorten-section/shorten-section.component';
import { UrlManagerSectionComponent } from './MainPageSections/url-manager-section/url-manager-section.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    ShortenSectionComponent,
    UrlManagerSectionComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
