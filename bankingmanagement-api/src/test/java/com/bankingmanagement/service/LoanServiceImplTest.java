package com.bankingmanagement.service;

import com.bankingmanagement.entity.Loan;
import com.bankingmanagement.exception.LoanNotFound;
import com.bankingmanagement.model.LoanDTO;
import com.bankingmanagement.repository.LoanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceImplTest {
    @Mock
    LoanRepository loanRepository;

    @InjectMocks
    LoanServiceImpl loanService;

    @Test
    public void testFindAllLoans() throws LoanNotFound {
        Loan loan = new Loan();
        loan.setLoanId(1);
        loan.setLoanAmount(50000);
        loan.setLoanType("Car Loan");

        List<Loan> loans = new ArrayList<>();
        loans.add(loan);

        when(loanRepository.findAll()).thenReturn(loans);
        List<LoanDTO> loanDTOList = loanService.findAllLoans();
        assertEquals(1, loanDTOList.size());
    }

    @Test(expected = LoanNotFound.class)
    public void testFindAllLoansWithEmptyData() throws LoanNotFound {
        when(loanRepository.findAll()).thenReturn(null);
        List<LoanDTO> loanDTOList = loanService.findAllLoans();
        assertNull(loanDTOList);
    }
}
