package org.ppke.itk.ticketingsystem.repository;

import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * repository class for Tickets table
 */
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
