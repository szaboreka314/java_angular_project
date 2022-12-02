import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";
import {Ticket} from "../create-ticket/model/ticket.model";

@Injectable()
export class UpdateTicketService {
  private ticketUrl = 'api/tickets/edit_ticket';

  constructor(private http: HttpClient, private messageService:MessageService) { }

  saveTicket(id: number, prio: number, status: string, resolution: string) : Observable<Ticket>{
    this.messageService.add("NewTicketService: new ticket created")
    console.log({"id": id, "priority" : prio, "status": status, "resolution": resolution})
    return this.http.put<Ticket>(this.ticketUrl, {"id": id, "priority" : prio, "status": status, "resolution": resolution});
  }
}
