package org.ppke.itk.ticketingsystem.repository;

import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
