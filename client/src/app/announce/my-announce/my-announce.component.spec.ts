import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyAnnounceComponent } from './my-announce.component';

describe('MyAnnounceComponent', () => {
  let component: MyAnnounceComponent;
  let fixture: ComponentFixture<MyAnnounceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyAnnounceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyAnnounceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
