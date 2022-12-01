import { Component, OnInit } from '@angular/core';
import {Ticket} from "../create-ticket/model/ticket.model";
import {MessageService} from "../services/message.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TicketService} from "../services/ticket.service";
import {Group} from "../create-ticket/model/group.model";
import {GroupService} from "../services/group.service";
import {UpdateTicketService} from "../services/update-ticket.service";

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent implements OnInit {

  ticket : Ticket | undefined;
  updatedTicket : Ticket | undefined;
  id : number = 0;
  statuses : String[] = [];
  resolution : String[] = [];

  constructor(private messageService:MessageService,
              private route: ActivatedRoute,
              private ticketService: TicketService,
              private updateTicketService: UpdateTicketService,
              private groupService: GroupService,
              private router: Router) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.initTickets();
      this.statuses = ["new", "in progress", "testing", "closed"];
      this.resolution = ["unresolved", "done"];
    });
  }

  initTickets(){
    this.ticketService.getTicketById(this.id).subscribe((ticket) => (this.ticket = ticket, this.updatedTicket = ticket));
  }

  onSaveClick(){
    console.log(this.updatedTicket)
    if(this.updatedTicket)
      this.updateTicketService.saveTicket(this.updatedTicket.id, this.updatedTicket.priority, this.updatedTicket.status, this.updatedTicket.resolution).subscribe((response: any) => {
        // @ts-ignore
        this.router.navigate(['/get_ticket_by_id/', this.ticket.id])
      });

  }

}
