import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesListComponent } from './proces-list.component';

describe('ProcesListComponent', () => {
  let component: ProcesListComponent;
  let fixture: ComponentFixture<ProcesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcesListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
