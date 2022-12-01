package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.ticketingsystem.domain.Group;
import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.ppke.itk.ticketingsystem.domain.User;
import org.ppke.itk.ticketingsystem.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/byId/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/users/loggedIn")
    public List<User> getLoggedInUser() {
        return userRepository.findAll();
    }


}
