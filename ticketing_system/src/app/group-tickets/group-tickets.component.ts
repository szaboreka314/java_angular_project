import { Component, OnInit } from '@angular/core';
import { Ticket } from '../create-ticket/model/ticket.model';
import {MessageService} from "../services/message.service";
import {ActivatedRoute, Router} from '@angular/router';
import {TicketService} from "../services/ticket.service";
import {UserService} from "../services/user.service";
import {User} from "../create-ticket/model/user.model";

@Component({
  selector: 'app-group-tickets',
  templateUrl: './group-tickets.component.html',
  styleUrls: ['./group-tickets.component.css']
})
export class GroupTicketsComponent implements OnInit {

  tickets : Ticket[] | undefined;
  name: string  = "";
  users : User[] | undefined;
  assignee : number = 0;

  constructor(private messageService:MessageService,
              private route: ActivatedRoute,
              private ticketService: TicketService,
              private userService: UserService,
              private router: Router) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.name = params['name'];
      this.initTickets();
      this.initUsers();
    });
  }

  initTickets(){
    this.ticketService.getTicketsByGroupName(this.name).subscribe((tickets) => this.tickets = tickets);
  }

  initUsers(){
    this.userService.getUsers().subscribe((users) => this.users = users);
  }

  filter(){
    console.log(this.assignee)
    this.ticketService.getTicketsByAssignee(this.assignee).subscribe((tickets) => this.tickets = tickets);
  }

}
