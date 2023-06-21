package com.bankingmanagement.repository;

import com.bankingmanagement.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;


    @Test
    public void testFindAll(){
        saveCustomer();
        List<Customer> customerList =  customerRepository.findAll();
        assertEquals(1, customerList.size());
    }

    private void saveCustomer(){
        Customer customer = new Customer();
        customer.setCustomerName("Ajay");
        customer.setCustomerAddress("Bangalore");
        customer.setCustomerPhone("998008783");

        customerRepository.save(customer);
    }
}
