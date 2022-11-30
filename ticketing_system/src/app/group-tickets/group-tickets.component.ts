import { Component, OnInit } from '@angular/core';
import { Ticket } from '../create-ticket/model/ticket.model';
import {MessageService} from "../services/message.service";
import {ActivatedRoute, Router} from '@angular/router';
import {TicketService} from "../services/ticket.service";

@Component({
  selector: 'app-group-tickets',
  templateUrl: './group-tickets.component.html',
  styleUrls: ['./group-tickets.component.css']
})
export class GroupTicketsComponent implements OnInit {

  tickets : Ticket[] | undefined;
  name: string  = "";

  constructor(private messageService:MessageService,
              private route: ActivatedRoute,
              private ticketService: TicketService,
              private router: Router) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.name = params['name'];
      this.initTickets();
    });
  }

  initTickets(){
    this.ticketService.getTicketsByGroupName(this.name).subscribe((tickets) => this.tickets = tickets);
  }

}
