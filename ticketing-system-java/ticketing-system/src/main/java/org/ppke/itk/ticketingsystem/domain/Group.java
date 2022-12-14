package org.ppke.itk.ticketingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * entity class for Groups table
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups", schema = "public")
public class Group implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
}
