import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassosListComponent } from './passos-list.component';

describe('PassosListComponent', () => {
  let component: PassosListComponent;
  let fixture: ComponentFixture<PassosListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassosListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
