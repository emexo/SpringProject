package com.bugtacking.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ApplicationVO {
    private long applicationId;
    private String applicationName;
    private String owner;
    private String description;
}
