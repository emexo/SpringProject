package com.bankingmanagement.model;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class BankDTO {
    private String bankName;
    private String bankAddress;
    private List<BranchDTO> branchDTOList;
}
