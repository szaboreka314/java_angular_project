import { Component, OnInit } from '@angular/core';
import {Ticket} from "../create-ticket/model/ticket.model";
import {MessageService} from "../services/message.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TicketService} from "../services/ticket.service";

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  ticket : Ticket | undefined;
  id : number = 0;

  constructor(private messageService:MessageService,
              private route: ActivatedRoute,
              private ticketService: TicketService,
              private router: Router) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.initTickets();
    });
  }

  initTickets(){
    this.ticketService.getTicketById(this.id).subscribe((ticket) => this.ticket = ticket);
  }
}
