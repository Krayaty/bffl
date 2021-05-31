import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { ShortenUrlPageComponent } from './Components/MainPages/shorten-url-page/shorten-url-page.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { BotbarComponent } from './Components/BottomBarComponents/botbar/botbar.component';
import { ImpressumComponent } from './Components/BottomBarComponents/impressum/impressum.component';
import { KontaktComponent } from './Components/BottomBarComponents/kontakt/kontakt.component';
import { DatenschutzComponent } from './Components/BottomBarComponents/datenschutz/datenschutz.component';
import { AgGridModule } from 'ag-grid-angular';
import { MainPageComponent } from './Components/MainPages/main-page/main-page.component';
import { TopbarComponent } from './Components/TopBarComponents/topbar/topbar.component';
import { GroupSelectionComponent } from './Components/TopBarComponents/group-selection/group-selection.component';
import { AuthService} from './Services/Iam-Services/auth.service';
import { keycloakInitializer} from './AppInit';
import { KeycloakService} from 'keycloak-angular';
import { AuthGuardService} from './Services/Iam-Services/auth-guard.service';
import { DbConnectorService} from './Services/DB-Connect-Services/db-connector.service';
import { AuthInterceptor} from './Services/Iam-Services/auth-interceptor.service';
import { ChooseGroupPageComponent } from './Components/MainPages/choose-group-page/choose-group-page.component';
import {ShortUrlDetailViewComponent} from './Components/SubViewComponents/short-url-detail-view/short-url-detail-view.component';
import {MatDialogModule} from '@angular/material/dialog';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    ShortenUrlPageComponent,
    BotbarComponent,
    ImpressumComponent,
    KontaktComponent,
    DatenschutzComponent,
    MainPageComponent,
    TopbarComponent,
    GroupSelectionComponent,
    ChooseGroupPageComponent,
    ShortUrlDetailViewComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        AgGridModule.withComponents([]),
        ReactiveFormsModule,
        MatDialogModule,
        BrowserAnimationsModule
    ],
  providers: [
    AuthService,
    KeycloakService,
    {
      provide: APP_INITIALIZER,
      useFactory: keycloakInitializer,
      multi: true,
      deps: [KeycloakService]
    },
    {
      provide : HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi   : true,
    },
    AuthGuardService,
    DbConnectorService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
