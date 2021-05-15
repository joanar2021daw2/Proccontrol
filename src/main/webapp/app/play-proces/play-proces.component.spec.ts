import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayProcesComponent } from './play-proces.component';

describe('PlayProcesComponent', () => {
  let component: PlayProcesComponent;
  let fixture: ComponentFixture<PlayProcesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayProcesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayProcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
