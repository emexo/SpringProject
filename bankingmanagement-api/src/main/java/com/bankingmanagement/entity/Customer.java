package com.bankingmanagement.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="Customer_TBL")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Customer_ID")
    private int customerID;

    @Column(name = "Customer_Name")
    private String customerName;

    @Column(name = "Customer_Address")
    private String customerAddress;

    @Column(name = "Customer_Phone")
    private String customerPhone;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accountSet;

}
