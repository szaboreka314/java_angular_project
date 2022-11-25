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

@NgModule({
  declarations: [
    AppComponent,
    AssignedTicketsComponent,
    HomeComponent,
    CreateTicketComponent,
    GroupTicketsComponent,
    TicketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
