import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BotbarComponent } from './botbar.component';
import {By} from '@angular/platform-browser';

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

  it('should contain 3 links', () => {
    expect(fixture.debugElement.queryAll(By.css('a')).length).toEqual(3);
  });

  it('should contain italic text', () => {
    expect(fixture.debugElement.query(By.css('i'))).toBeTruthy();
  });
});
