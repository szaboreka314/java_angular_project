package org.ppke.itk.ticketingsystem.repository;

import org.ppke.itk.ticketingsystem.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository class for Groups table
 */
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
