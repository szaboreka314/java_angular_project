import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {GroupTicketsComponent} from "./group-tickets.component";

const routes: Routes = [{ path: 'group-tickets/:name', component:
  GroupTicketsComponent, pathMatch: "full" }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class GroupTicketsRoutingModule { }
