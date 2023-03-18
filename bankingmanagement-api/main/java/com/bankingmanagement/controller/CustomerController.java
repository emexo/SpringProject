package com.bankingmanagement.controller;

import com.bankingmanagement.model.CustomerDTO;
import com.bankingmanagement.model.CustomerRequest;
import com.bankingmanagement.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // http://localhost:9090/api/v1/customers?id=2&name=name
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable("customerId") int customerId){
        log.info("Inside CustomerController.findCustomerById, customerId:{}", customerId);

        if(customerId <=0){
            log.info("Invalid customer id, customerId:{}", customerId);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomerDTO customerDTO = null;
        try{
            customerDTO = customerService.findCustomerById(customerId);
            log.info("Customer details for the customerId:{} and response:{}", customerId, customerDTO);

            if(customerDTO == null){
                log.info("Customer details not found for the customerId:{}", customerId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            log.error("Exception while getting customer details", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("Inside CustomerController.saveCustomer, customerRequest:{}", customerRequest);
        if(customerRequest == null) {
            log.info("Invalid customer request, customerRequest:{}", customerRequest);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomerDTO  customerDTO = null;
        try {
            customerDTO = customerService.saveCustomer(customerRequest);
            log.info("Customer details, customerDTO:{}", customerDTO);

            if(customerDTO == null) {
                log.info("Customer details not found for the customerDTO:{}", customerDTO);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            log.error("Exception while getting saving customer details", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("Inside CustomerController.saveCustomer, customerRequest:{}", customerRequest);
        if(customerRequest == null) {
            log.info("Invalid customer request, customerRequest:{}", customerRequest);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomerDTO  customerDTO = null;
        try {
            customerDTO = customerService.saveCustomer(customerRequest);
            log.info("Customer details, customerDTO:{}", customerDTO);

            if(customerDTO == null) {
                log.info("Customer details not found for the customerDTO:{}", customerDTO);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            log.error("Exception while getting saving customer details", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
    }
}
