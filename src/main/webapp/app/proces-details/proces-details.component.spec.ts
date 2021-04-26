import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesDetailsComponent } from './proces-details.component';

describe('ProcesDetailsComponent', () => {
  let component: ProcesDetailsComponent;
  let fixture: ComponentFixture<ProcesDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcesDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcesDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
