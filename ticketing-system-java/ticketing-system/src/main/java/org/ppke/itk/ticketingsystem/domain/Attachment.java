package org.ppke.itk.ticketingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups", schema = "public")
public class Attachment implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String filePath;

    private Date uploadedAt;

    @ManyToOne
    private Ticket ticketId;
}
