import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';

let fixture;
let app;
let root;

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
    fixture = TestBed.createComponent(AppComponent);
    app = fixture.componentInstance;
    root = fixture.nativeElement;
  });

  it('should create the app', () => {
    expect(app).toBeTruthy();
  });

  it(`should have as title 'BFFL'`, () => {
    expect(app.title).toEqual('BFFL-Shortener');
  });
});
