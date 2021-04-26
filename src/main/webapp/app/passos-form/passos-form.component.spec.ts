import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassosFormComponent } from './passos-form.component';

describe('PassosFormComponent', () => {
  let component: PassosFormComponent;
  let fixture: ComponentFixture<PassosFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassosFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassosFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
