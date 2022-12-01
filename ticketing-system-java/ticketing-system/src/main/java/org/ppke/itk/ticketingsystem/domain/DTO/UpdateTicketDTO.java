package org.ppke.itk.ticketingsystem.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateTicketDTO implements Serializable {

    public Integer id;
    public Integer priority;
    public String status;
    public String resolution;
}
