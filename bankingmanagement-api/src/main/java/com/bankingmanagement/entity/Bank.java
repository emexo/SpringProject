package com.bankingmanagement.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "Bank_TBL")
public class Bank implements Serializable {

    public static final long serialVersionUID = 4543545l;

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
