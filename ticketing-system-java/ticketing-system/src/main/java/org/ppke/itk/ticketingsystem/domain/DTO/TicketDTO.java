package org.ppke.itk.ticketingsystem.domain.DTO;

import lombok.*;
import org.ppke.itk.ticketingsystem.domain.Ticket;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDTO implements Serializable {

    private Ticket ticket;
    private Integer assigneeId;
}
