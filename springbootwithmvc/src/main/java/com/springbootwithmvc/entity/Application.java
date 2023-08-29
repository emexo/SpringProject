package com.springbootwithmvc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "application_name")
    private String applicationName;

    private String description;

    private String owner;
}
