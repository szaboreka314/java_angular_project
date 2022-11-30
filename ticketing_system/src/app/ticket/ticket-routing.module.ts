import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {TicketComponent} from "./ticket.component";

const routes: Routes = [{ path: 'get_ticket_by_id/:id', component:
  TicketComponent, pathMatch: "full" }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class TicketRoutingModule { }
