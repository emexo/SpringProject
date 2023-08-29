package com.springbootwithmvc.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationDTO {
    private Integer applicationId;

    private String applicationName;

    private String description;

    private String owner;
}
