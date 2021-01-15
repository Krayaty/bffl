import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BotbarComponent } from './botbar.component';

describe('BotbarComponent', () => {
  let component: BotbarComponent;
  let fixture: ComponentFixture<BotbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BotbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BotbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
