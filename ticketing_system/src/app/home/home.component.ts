import { Component, OnInit } from '@angular/core';
import {Ticket} from "../create-ticket/model/ticket.model";
import {TicketService} from "../services/ticket.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private ticketService: TicketService) { }

  tickets : Ticket[] = [];

  ngOnInit(): void {
    this.getLastModified();

  }

  initGroups(){
    this.ticketService.getTickets().subscribe((tickets) => this.tickets = tickets);
  }

  getLastModified(){
    this.ticketService.getLastModified().subscribe((tickets) => this.tickets = tickets);
  }
}
