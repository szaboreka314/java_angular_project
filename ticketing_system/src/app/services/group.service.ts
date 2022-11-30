import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "./message.service";
import {Observable, of} from "rxjs";
import {Group} from "../create-ticket/model/group.model";

@Injectable()
export class GroupService {
  private groupsUrl = 'api/groups';

  constructor(private http: HttpClient, private messageService:MessageService) { }

  getGroups(): Observable<Group[]> {
    const groups = this.http.get<Group[]>(this.groupsUrl);
    this.messageService.add("GroupService: fetched groups")
    return groups;
  }



}
