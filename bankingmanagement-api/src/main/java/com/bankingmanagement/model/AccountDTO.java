package com.bankingmanagement.model;

import com.bankingmanagement.entity.Branch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    private int accountNumber;
    private String accountType;
    private int accountBalance;
    private BranchDTO branchDTO;
    private CustomerDTO customerDTO;
}
