import { Component, OnInit } from '@angular/core';
import {NONE_TYPE} from "@angular/compiler";
import {NgForm} from "@angular/forms";
import {NewTicketService} from "../services/new-ticket.service";
import {NewTicket} from "./model/new-ticket.model";
import {Group} from "./model/group.model";
import {GroupService} from "../services/group.service";
import {User} from "./model/user.model";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent implements OnInit {

  public newTicket : NewTicket | undefined;
  groups : Group[] = [];
  users : User[] | undefined;
  assigneeId : number = 0;

  constructor(public newTicketService: NewTicketService,
              private groupService: GroupService,
              private userService: UserService,
              private router: Router) { }

  ngOnInit(): void {
    this.newTicket = new NewTicket("", "", 0, "", new Date(Date.now()), "unresolved", 'new');
    this.initGroups();
    this.initUsers();
  }

  onSubmit(newTicketForm: NgForm) {
    if(this.newTicket)
      this.newTicketService.saveTicket(this.newTicket, this.assigneeId).subscribe((response: any) => {
        console.log(response);
        this.router.navigate(['/get_ticket_by_id/', response])
      });
  }

  initGroups(){
    this.groupService.getGroups().subscribe((groups) => this.groups = groups);
  }

  initUsers(){
    this.userService.getUsers().subscribe((users) => this.users = users);
  }

}
