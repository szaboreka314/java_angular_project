import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {CreateTicketComponent} from "./create-ticket.component";

const routes: Routes = [{ path: 'create_ticket', component:
  CreateTicketComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CreateTicketRoutingModule { }
