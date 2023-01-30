import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowhotelComponent } from './showhotel.component';

describe('ShowhotelComponent', () => {
  let component: ShowhotelComponent;
  let fixture: ComponentFixture<ShowhotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowhotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowhotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
