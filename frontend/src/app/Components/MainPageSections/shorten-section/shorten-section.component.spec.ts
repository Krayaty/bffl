import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShortenSectionComponent } from './shorten-section.component';
import {By} from '@angular/platform-browser';

describe('ShortenSectionComponent', () => {
  let component: ShortenSectionComponent;
  let fixture: ComponentFixture<ShortenSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShortenSectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShortenSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have 2 inputs', () => {
    expect(fixture.debugElement.queryAll(By.css('input')).length).toBe(2);
  });
});
