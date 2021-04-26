import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesFormComponent } from './proces-form.component';

describe('ProcesFormComponent', () => {
  let component: ProcesFormComponent;
  let fixture: ComponentFixture<ProcesFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcesFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
