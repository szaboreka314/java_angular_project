package org.ppke.itk.ticketingsystem.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * entity class for Users table
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dummy_users", schema = "public")
public class User implements Serializable {
    @Id
    private Integer id;

    private String name;

    private String role;

    private String password;

    private String email;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignee")
    private List<Ticket> tickets;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private List<Ticket> ticketsCreatedByMe;
}
