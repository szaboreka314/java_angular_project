package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.ticketingsystem.domain.Group;
import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.ppke.itk.ticketingsystem.repository.GroupRepository;
import org.ppke.itk.ticketingsystem.repository.TicketRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller class for groups table
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class GroupController {

    private final GroupRepository groupRepository;

    /**
     * get all records from the groups table
     * @return all groups records
     */
    @GetMapping("/groups")
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

}
