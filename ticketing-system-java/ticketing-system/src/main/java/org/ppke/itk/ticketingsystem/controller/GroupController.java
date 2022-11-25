package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.ticketingsystem.domain.Group;
import org.ppke.itk.ticketingsystem.repository.GroupRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class GroupController {

    private final GroupRepository groupRepository;

    @GetMapping("/groups")
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
