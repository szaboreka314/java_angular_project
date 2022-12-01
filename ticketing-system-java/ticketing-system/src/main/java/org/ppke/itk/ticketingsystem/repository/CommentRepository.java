package org.ppke.itk.ticketingsystem.repository;

import org.ppke.itk.ticketingsystem.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository class for Comments table
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
