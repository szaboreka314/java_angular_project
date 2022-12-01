import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";
import {Comment} from "../create-ticket/model/comment.model";
import {NewComment} from "../create-ticket/model/new-comment.model"
import {NewTicket} from "../create-ticket/model/new-ticket.model";

@Injectable()
export class CommentService {
  private commentsUrl = 'api/comments/';

  constructor(private http: HttpClient, private messageService:MessageService) { }

  getComments(ticketId : number): Observable<Comment[]> {
    const comments = this.http.get<Comment[]>(this.commentsUrl + ticketId);
    return comments;
  }

  saveComment(ticketId: number, commentText: string): Observable<NewComment>{
    return this.http.post<NewComment>(this.commentsUrl + 'new_comment', {"ticketId": ticketId, "text": commentText, "createdAt": new Date(Date.now())});
  }

}
