package com.bugtacking.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "RELEASE_TBL")
public class Release {

    @Id
    @Column(name = "release_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="releaseIdGenerator" )
    @SequenceGenerator(name = "releaseIdGenerator", sequenceName = "release_id_sequence")
    private int releaseId;

    private String description;

    @Column(name = "release_date")
    private String releaseDate;
}
