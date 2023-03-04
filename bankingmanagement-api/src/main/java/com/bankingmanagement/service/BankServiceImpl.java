package com.bankingmanagement.service;

import antlr.StringUtils;
import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.entity.Branch;
import com.bankingmanagement.exception.BankDetailsNotFound;
import com.bankingmanagement.model.BankDTO;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BranchDTO;
import com.bankingmanagement.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BankServiceImpl implements BankService{
    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<BankDTO> findAll() throws BankDetailsNotFound{
        log.info("Inside the BankServiceImpl.findAll");
        List<Bank> banks =  bankRepository.findAll();

        log.info("List of Banks, banks:{}",banks);

        if(CollectionUtils.isEmpty(banks)){
            log.info("Bank details not found");
            throw new BankDetailsNotFound("Bank details not found");
        }

        List<BankDTO> bankDTOList =  banks.stream().map(bank -> {
            BankDTO bankDTO = new BankDTO();
            bankDTO.setBankName(bank.getBankName());
            bankDTO.setBankAddress(bank.getBankAddress());
            Set<Branch> branches = bank.getBranchSet();
            List<BranchDTO> branchDTOS =null;
            if(!CollectionUtils.isEmpty(branches)) {
                branchDTOS = branches.stream().map(branch -> {
                    BranchDTO branchDTO = new BranchDTO();
                    branchDTO.setBranchName(branch.getBranchName());
                    branchDTO.setBranchAddress(branch.getBranchAddress());
                    return branchDTO;
                }).collect(Collectors.toList());
            }
            bankDTO.setBranchDTOList(branchDTOS);
            return bankDTO;
        }).collect(Collectors.toList());

        return bankDTOList;
    }

    @Override
    public BankDTO findBankDetails(int code) throws BankDetailsNotFound {
        log.info("Input to BankServiceImpl.findBankDetails, code:{}", code);
        if(code <=0){
            log.info("Invalid bank code");
            throw new BankDetailsNotFound("Invalid Bank Code");
        }
        Optional<Bank> bank = bankRepository.findById(code);
        log.info("Bank details for the code: {} and the details:{}", code , bank.get());

        if(!bank.isPresent()){
            log.info("Bank details are not found for the bank code:{}", code);
            throw new BankDetailsNotFound("Bank details not found");
        }
        Bank bank1 = bank.get();
        BankDTO bankDTO = new BankDTO();
        bankDTO.setBankName(bank1.getBankName());
        bankDTO.setBankAddress(bank1.getBankAddress());

        Set<Branch> branches = bank1.getBranchSet();
        List<BranchDTO> branchDTOS = branches.stream().map(branch -> {
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setBranchName(branch.getBranchName());
            branchDTO.setBranchAddress(branch.getBranchAddress());
            return branchDTO;
        }).collect(Collectors.toList());
        bankDTO.setBranchDTOList(branchDTOS);

        log.info("End of BankServiceImpl.findBankDetails");
        return bankDTO;
    }

    @Override
    public BankDTO save(BankRequest bankRequest) throws BankDetailsNotFound {
        log.info("Input to BankServiceImpl.save, bankRequest:{} ", bankRequest);
        if(bankRequest == null){
            log.info("Invalid input");
            throw new BankDetailsNotFound("Invalid input");
        }
        Bank bank = new Bank();
        bank.setBankCode(bankRequest.getBankCode());
        bank.setBankName(bankRequest.getBankName());
        bank.setBankAddress(bankRequest.getBankAddress());
        Bank bank1 = bankRepository.save(bank);

        log.info("Bank details, bank:{}", bank1);
        BankDTO bankDTO = new BankDTO();
        bankDTO.setBankName(bank1.getBankName());
        bankDTO.setBankAddress(bank1.getBankAddress());
        return bankDTO;
    }

    @Override
    public String delete(int bankCode) throws BankDetailsNotFound {
        log.info("Input to BankingServiceImpl.delete, bankCode:{}", bankCode);
        if(bankCode <=0){
            log.info("Invalid bank Code");
            throw new BankDetailsNotFound("Invalid bank Code");
        }
        bankRepository.deleteById(bankCode);
        return "Bank details has been deleted";
    }


}
