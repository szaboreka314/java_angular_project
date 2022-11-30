import { Component } from '@angular/core';
import {Group} from "./create-ticket/model/group.model";
import {GroupService} from "./services/group.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [GroupService]
})
export class AppComponent {
  title = 'Dummy Ticketing System';

  constructor(private groupService: GroupService) { }

  groups : Group[] = [];

  ngOnInit(): void {
    this.initGroups();
  }

  initGroups(){
    this.groupService.getGroups().subscribe((groups) => this.groups = groups);
  }
}
