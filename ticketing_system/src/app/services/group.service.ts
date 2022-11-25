import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";
import {Group} from "../group-tickets/model/group.model";

@Injectable()
export class GroupService {
  private teamsUrl = 'api/teams';

  constructor(private http: HttpClient, private messageService:MessageService) { }

  getGroups(): Observable<Group[]> {
    const teams = this.http.get<Group[]>(this.teamsUrl);
    this.messageService.add("GroupService: fetched groups")
    return teams;
  }

}
