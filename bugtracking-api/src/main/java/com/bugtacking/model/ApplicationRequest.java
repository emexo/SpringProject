package com.bugtacking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequest {
    private long applicationId;
    private String applicationName;
    private String owner;
    private String description;

    @Override
    public String toString() {
        return "ApplicationRequest{" +
                "applicationId=" + applicationId +
                ", applicationName='" + applicationName + '\'' +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
