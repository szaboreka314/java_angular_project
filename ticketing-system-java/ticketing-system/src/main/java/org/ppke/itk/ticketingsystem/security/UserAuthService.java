package org.ppke.itk.ticketingsystem.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.ticketingsystem.domain.User;
import org.ppke.itk.ticketingsystem.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security class for user authentication
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User dbUser = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email %s"));
        return org.springframework.security.core.userdetails.User.builder()
                .username(email)
                .password(dbUser.getPassword())
                .authorities(dbUser.getRole())
                .build();
    }
}
