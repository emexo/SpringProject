package com.bankingmanagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountRequest {
    private String accountType;
    private int accountBalance;
}
