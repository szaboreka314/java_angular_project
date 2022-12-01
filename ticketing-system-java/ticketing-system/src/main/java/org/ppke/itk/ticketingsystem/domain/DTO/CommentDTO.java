package org.ppke.itk.ticketingsystem.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO class for Comment entity with the fields modifed by the user
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDTO {
    public String text;
    public Integer ticketId;
    public Date createdAt;
}
