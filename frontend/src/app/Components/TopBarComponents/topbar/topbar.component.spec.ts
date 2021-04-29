import {ComponentFixture, inject, TestBed} from '@angular/core/testing';

import { TopbarComponent } from './topbar.component';
import {AuthService} from '../../../Services/Iam-Services/auth.service';
import {KeycloakService} from 'keycloak-angular';
import {GroupSelectionComponent} from '../group-selection/group-selection.component';
import {By} from '@angular/platform-browser';

describe('TopbarComponent', () => {
  let component: TopbarComponent;
  let fixture: ComponentFixture<TopbarComponent>;
  let mockAuthService: AuthService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopbarComponent, GroupSelectionComponent ],
      providers: [ KeycloakService ]
    })
    .compileComponents();
    mockAuthService = TestBed.inject(AuthService);
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TopbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain 5 bar-buttons', () => {
    expect(fixture.debugElement.queryAll(By.css('.bar-button')).length).toBe(5);
  });

  it('should log out', () => {
    spyOn(mockAuthService, 'logout');

    const button = fixture.debugElement.nativeElement.querySelectorAll('a')[2];
    button.click();

    expect(mockAuthService.logout).toHaveBeenCalled();
  });
});
