import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseGroupPageComponent } from './choose-group-page.component';

describe('ChooseGroupPageComponent', () => {
  let component: ChooseGroupPageComponent;
  let fixture: ComponentFixture<ChooseGroupPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChooseGroupPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChooseGroupPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
