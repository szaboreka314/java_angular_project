import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {HomeRoutingModule} from "./home/home-routing.module";
import {CreateTicketRoutingModule} from "./create-ticket/create-ticket-routing.module";
import {GroupTicketsRoutingModule} from "./group-tickets/group-tickets-routing.module";
import {TicketRoutingModule} from "./ticket/ticket-routing.module";

const routes: Routes = [];

@NgModule({
  imports: [
    HomeRoutingModule,
    CreateTicketRoutingModule,
    GroupTicketsRoutingModule,
    TicketRoutingModule,
    RouterModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
