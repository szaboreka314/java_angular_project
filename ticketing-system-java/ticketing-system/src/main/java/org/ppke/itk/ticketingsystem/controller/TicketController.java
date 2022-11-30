package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.ppke.itk.ticketingsystem.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;

    @GetMapping("/tickets/last_modified")
    public List<Ticket> getLastFiveModified() {
        return ticketRepository.findAll().stream()
                .sorted(Comparator.comparing(Ticket::getCreatedAt))
                .toList();
    }

    @GetMapping("/tickets/{userName}")
    public List<Ticket> getAssigned() {
        return null;
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll().stream().toList();
    }

    @GetMapping("/tickets/byCategory/{category}")
    public List<Ticket> getAllByGroupName(@PathVariable String category) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getCategory().equals(category))
                .toList();
    }

    @GetMapping("/tickets/byId/{id}")
    public Ticket getTicket(@PathVariable Integer id) {
        return ticketRepository.findById(id).get();
    }

    @PostMapping(value = "/tickets/new_ticket")
    public void saveTicket(@RequestBody Ticket ticket){
        log.warn(ticket.toString());
        ticketRepository.save(ticket);
    }
}
