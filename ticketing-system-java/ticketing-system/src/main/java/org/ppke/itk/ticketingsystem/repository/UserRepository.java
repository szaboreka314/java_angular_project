package org.ppke.itk.ticketingsystem.repository;

import org.ppke.itk.ticketingsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * repository class for Users table
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
