package org.ppke.itk.ticketingsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String email;

    private Boolean isManager;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;

    @JsonIgnore
    //@JsonBackReference("assignee")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignee")
    private List<Ticket> tickets;

    @JsonIgnore
    //@JsonBackReference("created_by")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private List<Ticket> ticketsCreatedByMe;
}
