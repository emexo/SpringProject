package com.bankingmanagement.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Bank_TBL")
public class Bank {
    @Id
    @Column(name = "Bank_Code")
    private int bankCode;

    @Column(name = "Bank_Name")
    private String bankName;

    @Column(name = "Bank_Address")
    private String bankAddress;

    @OneToMany(mappedBy = "bank")
    private Set<Branch> branchSet;

}
