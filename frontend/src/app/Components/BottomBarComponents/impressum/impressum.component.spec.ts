import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImpressumComponent } from './impressum.component';
import {By} from "@angular/platform-browser";

describe('ImpressumComponent', () => {
  let component: ImpressumComponent;
  let fixture: ComponentFixture<ImpressumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImpressumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImpressumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have a header', () => {
    expect(fixture.debugElement.query(By.css('h1'))).toBeTruthy();
  });

  it('should have more than one paragraph', () => {
    expect(fixture.debugElement.queryAll(By.css('p')).length).toBeGreaterThan(1);
  });
});
