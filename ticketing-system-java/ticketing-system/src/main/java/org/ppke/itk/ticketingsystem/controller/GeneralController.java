package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.ticketingsystem.domain.User;
import org.ppke.itk.ticketingsystem.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class GeneralController {

    private final UserRepository userRepository;

    @GetMapping("/home")
    public User get(Principal principal) {
        return userRepository.findByEmail(principal.getName()).get();
    }
}
