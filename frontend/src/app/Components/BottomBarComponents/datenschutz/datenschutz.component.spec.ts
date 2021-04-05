import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatenschutzComponent } from './datenschutz.component';
import {By} from '@angular/platform-browser';

describe('DatenschutzComponent', () => {
  let component: DatenschutzComponent;
  let fixture: ComponentFixture<DatenschutzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatenschutzComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DatenschutzComponent);
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
