import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import {TopbarComponent} from './Components/TopBarComponents/topbar/topbar.component';
import {BotbarComponent} from './Components/BottomBarComponents/botbar/botbar.component';
import {ChildrenOutletContexts, RouterOutlet} from '@angular/router';
import {KeycloakService} from 'keycloak-angular';
import {GroupSelectionComponent} from './Components/TopBarComponents/group-selection/group-selection.component';

let fixture;
let app;
let root;

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        AppComponent, TopbarComponent, BotbarComponent, RouterOutlet, GroupSelectionComponent
      ],
      providers: [ KeycloakService, ChildrenOutletContexts ]
    }).compileComponents();
    fixture = TestBed.createComponent(AppComponent);
    app = fixture.componentInstance;
    root = fixture.nativeElement;
  });

  it('should create the app', () => {
    expect(app).toBeTruthy();
  });

  it('should have "BFFL" as title', () => {
    expect(app.title).toBe('BFFL-Shortener');
  });
});
