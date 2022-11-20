package org.ppke.itk.ticketingsystem.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String description;

    private Date createdAt;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User assignee;
}
