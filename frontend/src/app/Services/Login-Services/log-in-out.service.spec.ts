import { TestBed } from '@angular/core/testing';

import { LogInOutService } from './log-in-out.service';

describe('LogInOutService', () => {
  let service: LogInOutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LogInOutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
