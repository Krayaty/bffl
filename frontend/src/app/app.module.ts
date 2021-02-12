import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { ShortenSectionComponent } from './Components/MainPageSections/shorten-section/shorten-section.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BotbarComponent } from './Components/BottomBarComponents/botbar/botbar.component';
import { ImpressumComponent } from './Components/BottomBarComponents/impressum/impressum.component';
import { KontaktComponent } from './Components/BottomBarComponents/kontakt/kontakt.component';
import { DatenschutzComponent } from './Components/BottomBarComponents/datenschutz/datenschutz.component';
import { AgGridModule } from 'ag-grid-angular';
import { MainPageComponent } from './Components/MainPageSections/main-page/main-page.component';
import { TopbarComponent } from './Components/TopBarComponents/topbar/topbar.component';
import { UserSelectionComponent } from './Components/TopBarComponents/user-selection/user-selection.component';
import { AuthService } from './Services/Iam-Services/auth.service';
import { KeycloakService } from 'keycloak-angular';
import { initializer } from './AppInit';

@NgModule({
  declarations: [
    AppComponent,
    ShortenSectionComponent,
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
  providers: [
    KeycloakService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      deps: [KeycloakService],
      multi: true
    },
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
