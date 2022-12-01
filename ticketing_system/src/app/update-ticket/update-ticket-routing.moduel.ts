import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {UpdateTicketComponent} from "./update-ticket.component";

const routes: Routes = [{ path: 'get_ticket_by_id/:id/edit', component:
  UpdateTicketComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class UpdateTicketRoutingModuel { }
