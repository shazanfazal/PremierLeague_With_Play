import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchPreviewTableComponent } from './match-preview-table.component';

describe('MatchPreviewTableComponent', () => {
  let component: MatchPreviewTableComponent;
  let fixture: ComponentFixture<MatchPreviewTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchPreviewTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchPreviewTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
