import {User} from "./user.model";

export class Comment {
  public text: string;
  public userId: User
  constructor(text: string, user: User){
    this.text = text;
    this.userId = user;
  }
}
