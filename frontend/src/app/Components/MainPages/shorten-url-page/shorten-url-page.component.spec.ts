import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ShortenUrlPageComponent } from './shorten-url-page.component';
import {By} from '@angular/platform-browser';

describe('ShortenSectionComponent', () => {
  let component: ShortenUrlPageComponent;
  let fixture: ComponentFixture<ShortenUrlPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShortenUrlPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShortenUrlPageComponent);
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
