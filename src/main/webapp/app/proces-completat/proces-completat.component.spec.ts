import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesCompletatComponent } from './proces-completat.component';

describe('ProcesCompletatComponent', () => {
  let component: ProcesCompletatComponent;
  let fixture: ComponentFixture<ProcesCompletatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcesCompletatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcesCompletatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
