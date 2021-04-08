import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KontaktComponent } from './kontakt.component';
import {By} from '@angular/platform-browser';

describe('KontaktComponent', () => {
  let component: KontaktComponent;
  let fixture: ComponentFixture<KontaktComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KontaktComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KontaktComponent);
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
