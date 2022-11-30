import { Component, OnInit } from '@angular/core';
import {NONE_TYPE} from "@angular/compiler";
import {NgForm} from "@angular/forms";
import {NewTicketService} from "../services/new-ticket.service";
import {NewTicket} from "./model/new-ticket.model";
import {Group} from "./model/group.model";
import {GroupService} from "../services/group.service";

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent implements OnInit {

  public newTicket : NewTicket | undefined;
  groups : Group[] = [];
 // users : User[] | undefined;
  users: undefined;

  constructor(public newTicketService: NewTicketService, private groupService: GroupService) { }

  ngOnInit(): void {
    this.newTicket = new NewTicket("", "", 0, "", 1, 2);
    this.initGroups();
  }

  onSubmit(newTicketForm: NgForm) {
    if(this.newTicket)
      this.newTicketService.saveTicket(this.newTicket).subscribe((response: any) => {
        console.log(response);
      });
  }

  initGroups(){
    this.groupService.getGroups().subscribe((groups) => this.groups = groups);
    console.log(this.groups);
  }

}
