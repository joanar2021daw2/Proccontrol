import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayPasComponent } from './play-pas.component';

describe('PlayPasComponent', () => {
  let component: PlayPasComponent;
  let fixture: ComponentFixture<PlayPasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayPasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayPasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
