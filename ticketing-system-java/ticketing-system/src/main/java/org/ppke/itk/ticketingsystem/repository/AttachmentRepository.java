package org.ppke.itk.ticketingsystem.repository;

import org.ppke.itk.ticketingsystem.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository class for Attachments table, not used
 */
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
