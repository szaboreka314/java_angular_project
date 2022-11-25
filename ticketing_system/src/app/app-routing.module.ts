import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {HomeRoutingModule} from "./home/home-routing.module";
import {CreateTicketRoutingModule} from "./create-ticket/create-ticket-routing.module";

const routes: Routes = [];

@NgModule({
  imports: [
    HomeRoutingModule,
    CreateTicketRoutingModule,
    RouterModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
