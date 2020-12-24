import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPlayMatchComponent } from './add-play-match.component';

describe('AddPlayMatchComponent', () => {
  let component: AddPlayMatchComponent;
  let fixture: ComponentFixture<AddPlayMatchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPlayMatchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPlayMatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
