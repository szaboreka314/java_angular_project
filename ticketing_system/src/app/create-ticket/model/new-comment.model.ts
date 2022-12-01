import {User} from "./user.model";

export class NewComment {
  public text: string;
  public ticketId: number;
  public createdAt : Date;
  constructor(text: string, ticketId: number, createdAt: Date){
    this.text = text;
    this.ticketId = ticketId;
    this.createdAt = createdAt;
  }
}
