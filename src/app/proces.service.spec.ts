import { TestBed } from '@angular/core/testing';

import { ProcesService } from './proces.service';

describe('ProcesService', () => {
  let service: ProcesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProcesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
