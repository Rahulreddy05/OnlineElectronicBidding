import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingninSignoutComponent } from './singnin-signout.component';

describe('SingninSignoutComponent', () => {
  let component: SingninSignoutComponent;
  let fixture: ComponentFixture<SingninSignoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingninSignoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingninSignoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
