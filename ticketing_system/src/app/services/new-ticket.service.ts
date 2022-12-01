import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";
import {Group} from "../create-ticket/model/group.model";
import {NewTicket} from "../create-ticket/model/new-ticket.model";

@Injectable()
export class NewTicketService {
  private ticketUrl = 'api/tickets/new_ticket';

  constructor(private http: HttpClient, private messageService:MessageService) { }

  saveTicket(ticket: NewTicket, assigneeId : number) : Observable<NewTicket>{
    console.log({"ticket": ticket, "assigneeId": assigneeId});
    this.messageService.add("NewTicketService: new ticket created")
    return this.http.post<NewTicket>(this.ticketUrl, {"ticket": ticket, "assigneeId": assigneeId});
  }
}
