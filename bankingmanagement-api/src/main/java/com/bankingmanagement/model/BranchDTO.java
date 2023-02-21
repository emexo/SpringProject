package com.bankingmanagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Data
public class BranchDTO {
    private String branchName;
    private String branchAddress;
}
