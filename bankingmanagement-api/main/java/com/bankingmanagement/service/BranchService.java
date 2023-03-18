package com.bankingmanagement.service;

import com.bankingmanagement.exception.BranchDetailsNotFound;
import com.bankingmanagement.model.BranchDTO;

public interface BranchService {
    BranchDTO getBranchById(int branchCode) throws BranchDetailsNotFound;
    BranchDTO getBranchByName(String branchName) throws BranchDetailsNotFound, InterruptedException;
    public void clearCache();
}
