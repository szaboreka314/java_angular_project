package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.ppke.itk.ticketingsystem.domain.User;
import org.ppke.itk.ticketingsystem.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

/**
 * general controller class
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class GeneralController {

    private final UserRepository userRepository;

    /**
     * get specific user
     * @param principal object for user identification
     * @return user find by email address
     */
    @GetMapping("/home")
    public User get(Principal principal) {
        return userRepository.findByEmail(principal.getName()).get();
    }

    /**
     * get logo of the app
     * @return the logo of the application
     * @throws IOException if the inputstream cannot be cast
     */
    @GetMapping(
            value = "/logo",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getLogo() throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/logo.jpg");
        return IOUtils.toByteArray(in);
    }
}
