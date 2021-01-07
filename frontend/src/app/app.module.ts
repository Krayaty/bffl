import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ShortenSectionComponent } from './Components/MainPageSections/shorten-section/shorten-section.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './Components/StartUpComponents/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { BotbarComponent } from './Components/BottomBarComponents/botbar/botbar.component';
import { ImpressumComponent } from './Components/BottomBarComponents/impressum/impressum.component';
import { KontaktComponent } from './Components/BottomBarComponents/kontakt/kontakt.component';
import { DatenschutzComponent } from './Components/BottomBarComponents/datenschutz/datenschutz.component';
import {AgGridModule} from 'ag-grid-angular';
import {MainPageComponent} from './Components/MainPageSections/main-page/main-page.component';
import { TopbarComponent } from './Components/TopBarComponents/topbar/topbar.component';
import { UserSelectionComponent } from './Components/TopBarComponents/user-selection/user-selection.component';

@NgModule({
  declarations: [
    AppComponent,
    ShortenSectionComponent,
    LoginComponent,
    BotbarComponent,
    ImpressumComponent,
    KontaktComponent,
    DatenschutzComponent,
    MainPageComponent,
    TopbarComponent,
    UserSelectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AgGridModule.withComponents([])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
