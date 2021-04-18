import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProcesComponent } from './update-proces.component';

describe('UpdateProcesComponent', () => {
  let component: UpdateProcesComponent;
  let fixture: ComponentFixture<UpdateProcesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProcesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateProcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
