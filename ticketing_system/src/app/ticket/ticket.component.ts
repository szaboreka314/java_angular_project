import { Component, OnInit } from '@angular/core';
import {Ticket} from "../create-ticket/model/ticket.model";
import {Comment} from "../create-ticket/model/comment.model"
import {MessageService} from "../services/message.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TicketService} from "../services/ticket.service";
import {CommentService} from "../services/comment.service";
import {UserService} from "../services/user.service";
import { User } from '../create-ticket/model/user.model';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  ticket : Ticket | undefined;
  id : number = 0;
  comments : Comment[] = [];
  newComment : string = "";
  user : User | undefined;

  constructor(private messageService:MessageService,
              private route: ActivatedRoute,
              private ticketService: TicketService,
              private commentService: CommentService,
              public userService: UserService,
              private router: Router) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.initTickets();
      this.initComments();
    });
  }

  initTickets(){
    this.ticketService.getTicketById(this.id).subscribe((ticket) => this.ticket = ticket);
  }

  initComments(){
    this.commentService.getComments(this.id).subscribe((comments) => (this.comments = comments, console.log(this.comments)));
  }

  onDelete(){
    if(this.id)
      this.ticketService.deleteTicket(this.id).subscribe((response: any) => {
        // @ts-ignore
        this.router.navigate(['/home/'])
      });
  }

  saveComment(){
    if(this.newComment)
      this.commentService.saveComment(this.id, this.newComment).subscribe((response: any) => {
        console.log(response);

        this.ngOnInit();
      });
  }
}
