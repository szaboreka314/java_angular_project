import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";
import {User} from "../create-ticket/model/user.model";

@Injectable()
export class UserService {
  private usersUrl = 'api/users';

  constructor(private http: HttpClient, private messageService:MessageService) { }

  getUsers(): Observable<User[]> {
    const users = this.http.get<User[]>(this.usersUrl);
    this.messageService.add("UserService: fetched users")
    return users;
  }

  getUserById(id: number): Observable<User>{
    const user = this.http.get<User>(this.usersUrl + '/byId/' + id);
    return user;
  }

}
