package org.ppke.itk.ticketingsystem.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.ppke.itk.ticketingsystem.domain.DTO.TicketDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * entity class for Tickets table
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets", schema = "public")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "public.hibernate_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private String category;

    private Integer priority;

    private String status;

    private String resolution;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assignee")
    private User assignee;
}
