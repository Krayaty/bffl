import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainPageComponent } from './main-page.component';
import {HttpClient, HttpHandler} from '@angular/common/http';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {KeycloakService} from 'keycloak-angular';
import {AgGridAngular} from 'ag-grid-angular';
import {By} from '@angular/platform-browser';

describe('MainPageComponent', () => {
  let component: MainPageComponent;
  let fixture: ComponentFixture<MainPageComponent>;
  let mockDbConnectorService: DbConnectorService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainPageComponent, AgGridAngular ],
      providers: [ HttpClient, HttpHandler, KeycloakService ]
    })
    .compileComponents();
    mockDbConnectorService = TestBed.inject(DbConnectorService);
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MainPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have an ag-grid', () => {
    expect(fixture.debugElement.query(By.css('.ag-root'))).toBeTruthy();
  });

  it('should reload', () => {
    spyOn(component, 'retrieveAllShortURLsByGroupName');

    const button = fixture.debugElement.nativeElement.querySelectorAll('.button')[1];
    button.click();

    expect(component.retrieveAllShortURLsByGroupName).toHaveBeenCalled();
  });
});
