import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupTicketsComponent } from './group-tickets.component';

describe('GroupTicketsComponent', () => {
  let component: GroupTicketsComponent;
  let fixture: ComponentFixture<GroupTicketsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroupTicketsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GroupTicketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
