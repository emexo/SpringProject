package com.bankingmanagement.service;

import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.entity.Branch;
import com.bankingmanagement.exception.BankDetailsNotFound;
import com.bankingmanagement.model.BankDTO;
import com.bankingmanagement.repository.BankRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankServiceImplTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankServiceImpl bankService;

    @Test
    public void testFindAll() throws BankDetailsNotFound {
        Bank bank = new Bank();
        bank.setBankCode(999);
        bank.setBankName("SBI");
        bank.setBankAddress("Mumbai");
        List<Bank> banks = new ArrayList<>();
        banks.add(bank);

        when(bankRepository.findAll()).thenReturn(banks);

        List<BankDTO> bankDTOList= bankService.findAll();
        assertEquals(1, bankDTOList.size());
    }

    @Test
    public void testFindAllWithBranch() throws BankDetailsNotFound {
        Bank bank = new Bank();
        bank.setBankCode(999);
        bank.setBankName("SBI");
        bank.setBankAddress("Mumbai");

        Branch branch = new Branch();
        branch.setBranchId(1);
        branch.setBranchName("EC Branch");
        branch.setBranchAddress("ECity");
        Set<Branch> branches = new HashSet<>();
        branches.add(branch);

        bank.setBranchSet(branches);
        List<Bank> banks = new ArrayList<>();
        banks.add(bank);

        when(bankRepository.findAll()).thenReturn(banks);

        List<BankDTO> bankDTOList= bankService.findAll();
        assertEquals(1, bankDTOList.size());
    }

    @Test(expected = BankDetailsNotFound.class)
    public void testFindAllWithEmptyData() throws BankDetailsNotFound {
        List<Bank> banks = null;
        when(bankRepository.findAll()).thenReturn(banks);

        List<BankDTO> bankDTOList= bankService.findAll();
        assertNull(bankDTOList);
    }

    @Test
    public void testFindBankDetails() throws BankDetailsNotFound {
        Bank bank = new Bank();
        bank.setBankCode(999);
        bank.setBankName("SBI");
        bank.setBankAddress("Mumbai");
        when(bankRepository.findById(anyInt())).thenReturn(Optional.of(bank));

        BankDTO bankDTO = bankService.findBankDetails(999);
        assertEquals("SBI", bankDTO.getBankName());
        assertEquals("Mumbai", bankDTO.getBankAddress());
    }

    @Test(expected = BankDetailsNotFound.class)
    public void testFindBankDetailsWithInvalidInput() throws BankDetailsNotFound {

        BankDTO bankDTO = bankService.findBankDetails(0);
        assertNull(bankDTO);
    }
}
