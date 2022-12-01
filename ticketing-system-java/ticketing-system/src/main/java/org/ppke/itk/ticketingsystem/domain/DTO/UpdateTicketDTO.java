package org.ppke.itk.ticketingsystem.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO class for ticket entity with the fields modifed by the user
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateTicketDTO implements Serializable {

    public Integer id;
    public Integer priority;
    public String status;
    public String resolution;
}
