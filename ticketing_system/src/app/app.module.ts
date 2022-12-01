import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AssignedTicketsComponent } from './assigned-tickets/assigned-tickets.component';
import { HomeComponent } from './home/home.component';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import { GroupTicketsComponent } from './group-tickets/group-tickets.component';
import { TicketComponent } from './ticket/ticket.component';
import { HttpClientModule } from '@angular/common/http';
import {TicketService} from "./services/ticket.service";
import {TicketRoutingModule} from "./ticket/ticket-routing.module";
import {FormsModule} from "@angular/forms";
import {NewTicketService} from "./services/new-ticket.service";
import {NewTicketValidatorDirective} from "./create-ticket/validator/new-ticket-validator.directive";
import {UserService} from "./services/user.service";
import { UpdateTicketComponent } from './update-ticket/update-ticket.component';
import {UpdateTicketService} from "./services/update-ticket.service";
import {CommentService} from "./services/comment.service";

@NgModule({
  declarations: [
    AppComponent,
    AssignedTicketsComponent,
    HomeComponent,
    CreateTicketComponent,
    GroupTicketsComponent,
    TicketComponent,
    NewTicketValidatorDirective,
    UpdateTicketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TicketService, NewTicketService, UserService, UpdateTicketService, CommentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
