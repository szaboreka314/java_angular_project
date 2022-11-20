package org.ppke.itk.ticketingsystem.repository;

import org.ppke.itk.ticketingsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
