package com.bankingmanagement.repository;

import com.bankingmanagement.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
