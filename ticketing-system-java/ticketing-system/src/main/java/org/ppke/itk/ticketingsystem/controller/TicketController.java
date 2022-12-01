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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.security.Principal;
import java.util.Comparator;
import java.util.List;

/**
 * controller class for tickets table
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    /**
     * get the last five modified tickets
     * @return five tickets order by creation time
     */
    @GetMapping("/tickets/last_modified")
    public List<Ticket> getLastFiveModified() {
        return ticketRepository.findAll().stream()
                .sorted(Comparator.comparing(Ticket::getCreatedAt)).limit(5)
                .toList();
    }

    /**
     * get all records from tickets table
     * @param limit size of page
     * @param sort sorting method
     * @return requested limit number of tickets order by creation time
     */
    @GetMapping("/tickets")
    public List<Ticket> getAllTickets(@RequestParam(required = false, defaultValue = "100") Integer limit,
                                      @RequestParam(required = false, defaultValue = "desc") String sort){

        if ( !sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc") ) {
            throw new IllegalArgumentException("Invalid sorting param!!!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "createdAt") : Sort.by(Sort.Direction.DESC, "createdAt");

        Page<Ticket> tickets = ticketRepository.findAll(PageRequest.of(0, limit, sortParam ));
        return tickets.toList();
    }

    /**
     * get tickets based on category
     * @param category requested category by user
     * @return all tickets filtered by category
     */
    @GetMapping("/tickets/byCategory/{category}")
    public List<Ticket> getAllByGroupName(@PathVariable String category) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getCategory().equals(category))
                .toList();
    }

    /**
     * get a specific ticket
     * @param id of the ticket requested by user
     * @return the requested tickets record
     */
    @GetMapping("/tickets/byId/{id}")
    public Ticket getTicket(@PathVariable Integer id) {
        return ticketRepository.findById(id).get();
    }

    /**
     * create new ticket
     * @param ticketDTO DTO for new ticket
     * @param principal object for user identification
     */
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

    /**
     * update ticket
     * @param updateTicketDTO DTO for the updating fields
     * @param securityContextHolder object for user identification
     */
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

    /**
     * delete ticket
     * @param id of ticket for deleting
     */
    @DeleteMapping("/tickets/delete/{id}")
    public void deleteTicket(@PathVariable Integer id){
        log.warn(id.toString());
        ticketRepository.deleteById(id);
    }

}
