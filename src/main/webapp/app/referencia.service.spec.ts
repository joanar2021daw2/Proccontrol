import { TestBed } from '@angular/core/testing';

import { ReferenciaService } from './referencia.service';

describe('ReferenciaService', () => {
  let service: ReferenciaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReferenciaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
