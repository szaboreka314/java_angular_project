import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";
import {Ticket} from "../create-ticket/model/ticket.model";

@Injectable()
export class TicketService {
  private ticketsUrl = 'api/tickets';
  private lastModifiedUrl = 'api/tickets/last_modified'

  constructor(private http: HttpClient, private messageService:MessageService) { }

  getTickets(): Observable<Ticket[]> {
    const tickets = this.http.get<Ticket[]>(this.ticketsUrl);
    this.messageService.add("TicketService: fetched tickets")
    return tickets;
  }

  getTicketById(id: number): Observable<Ticket>{
    return this.http.get<Ticket>(this.ticketsUrl + '/byId/' + id);
  }

  getLastModified(): Observable<Ticket[]>{
    return  this.http.get<Ticket[]>(this.lastModifiedUrl);
  }

  getTicketsByGroupName(category: string): Observable<Ticket[]>{
    return this.http.get<Ticket[]>(this.ticketsUrl + '/byCategory/' + category);
  }

  getTicketsByAssignee(id: number): Observable<Ticket[]>{
    return this.http.get<Ticket[]>(this.ticketsUrl + '/byAssignee/' + id);
  }

  deleteTicket(id: number): Observable<Ticket>{
    return this.http.delete<Ticket>(this.ticketsUrl+'/delete/' + id);
  }

  getAssignedMeTickets(): Observable<Ticket[]>{
    return this.http.get<Ticket[]>(this.ticketsUrl + '/assignedMe');
  }

}
