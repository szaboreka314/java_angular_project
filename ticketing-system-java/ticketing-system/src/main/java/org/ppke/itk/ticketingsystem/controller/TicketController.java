package org.ppke.itk.ticketingsystem.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.ticketingsystem.domain.DTO.TicketDTO;
import org.ppke.itk.ticketingsystem.domain.DTO.UpdateTicketDTO;
import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.ppke.itk.ticketingsystem.domain.User;
import org.ppke.itk.ticketingsystem.repository.TicketRepository;
import org.ppke.itk.ticketingsystem.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.security.Principal;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

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

    @PostMapping(value = "/tickets/new_ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveTicket(@RequestBody TicketDTO ticketDTO, Principal principal){
        User createdBy = userRepository.findByEmail(principal.getName()).get();
        User assignee = userRepository.findById(ticketDTO.getAssigneeId()).get();
        Ticket ticket = ticketDTO.getTicket();
        ticket.setAssignee(assignee);
        ticket.setCreatedBy(createdBy);
        //ticket.setId(10);
        ticketRepository.save(ticket);
    }

    @PutMapping(value = "/tickets/edit_ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editTicket(@RequestBody UpdateTicketDTO updateTicketDTO, SecurityContextHolder securityContextHolder){
        Ticket ticket = ticketRepository.findById(updateTicketDTO.getId()).get();
        String loggedInUserName =  securityContextHolder.getContext().getAuthentication().getName();
        String loggedInUserRole = securityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        if((loggedInUserRole.equals("ROLE_USER") && ticket.getCreatedBy().equals(loggedInUserName)) || loggedInUserRole.equals("ROLE_ADMIN")){
            ticket.setPriority(updateTicketDTO.getPriority());
            ticket.setResolution(updateTicketDTO.getResolution());
            ticket.setStatus(updateTicketDTO.getStatus());
            ticketRepository.save(ticket);
        }

    }

    @DeleteMapping("/tickets/delete/{id}")
    public void deleteTicket(@PathVariable Integer id){
        log.warn(id.toString());
        ticketRepository.deleteById(id);
    }

}
