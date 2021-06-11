import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShortUrlDetailViewComponent } from './short-url-detail-view.component';

describe('ShortUrlDetailViewComponent', () => {
  let component: ShortUrlDetailViewComponent;
  let fixture: ComponentFixture<ShortUrlDetailViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShortUrlDetailViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShortUrlDetailViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
