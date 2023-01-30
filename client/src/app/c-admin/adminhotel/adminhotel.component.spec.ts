import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminhotelComponent } from './adminhotel.component';

describe('AdminhotelComponent', () => {
  let component: AdminhotelComponent;
  let fixture: ComponentFixture<AdminhotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminhotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminhotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
