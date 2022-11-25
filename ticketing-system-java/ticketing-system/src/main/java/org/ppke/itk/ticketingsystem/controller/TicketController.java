package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.ppke.itk.ticketingsystem.repository.TicketRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;

    @GetMapping("/last_modified")
    public List<Ticket> getLastFiveModified() {
        return ticketRepository.findAll().stream()
                .sorted(Comparator.comparing(Ticket::getCreatedAt))
                .toList();
    }

    @GetMapping("/assigned")
    public List<Ticket> getAssigned() {
        return null;
    }

    @GetMapping("/ticket_by_group_name/{groupName}")
    public List<Ticket> getAllByGroupName(@PathVariable String groupName) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getAssignee().getGroupId().getName().equals(groupName))
                .toList();
    }

    @GetMapping("/get_ticket_by_id/{id}")
    public Ticket getTicket(@PathVariable Integer id) {
        return ticketRepository.getReferenceById(id);
    }
}
