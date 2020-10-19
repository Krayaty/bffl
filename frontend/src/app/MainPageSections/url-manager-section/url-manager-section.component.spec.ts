import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UrlManagerSectionComponent } from './url-manager-section.component';

describe('UrlManagerSectionComponent', () => {
  let component: UrlManagerSectionComponent;
  let fixture: ComponentFixture<UrlManagerSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UrlManagerSectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UrlManagerSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
