package com.bankingmanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
}
