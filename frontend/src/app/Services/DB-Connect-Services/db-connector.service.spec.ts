import { TestBed } from '@angular/core/testing';

import { DbConnectorService } from './db-connector.service';

describe('DbConnectorService', () => {
  let service: DbConnectorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DbConnectorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
