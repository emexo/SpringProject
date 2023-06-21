package com.bankingmanagement.repository;

import com.bankingmanagement.entity.Branch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BranchRepositoryTest {

    @Autowired
    BranchRepository branchRepository;

    @Test
    public void testFindByBranchName(){
        saveBranch();
        Optional<Branch>  branchOptional = branchRepository.findByBranchName("BTM");
        assertEquals("BTM", branchOptional.get().getBranchName());
        assertEquals("Bangalore", branchOptional.get().getBranchAddress());
    }

    public void saveBranch(){
        Branch branch = new Branch();
        branch.setBranchName("BTM");
        branch.setBranchAddress("Bangalore");
        branchRepository.save(branch);

    }
}
