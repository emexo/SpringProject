package com.bankingmanagement.controller;

import com.bankingmanagement.model.BankDTO;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public ResponseEntity<List<BankDTO>> getBanks(){
        log.info("Inside the BankController.getBanks");
        List<BankDTO> bankDTOList = null;
        try{
            bankDTOList = bankService.findAll();
            log.info("Bank details, bankDTOList:{}", bankDTOList);

            if(CollectionUtils.isEmpty(bankDTOList)){
                log.info("Bank details not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            log.error("Exception while getting bank details");
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<BankDTO>>(bankDTOList, HttpStatus.OK);
    }

    // http://localhost:9090/api/v1/banks/999
    // http://localhost:9090/api/v1/banks?code=999
    @GetMapping("/{code}")
    public ResponseEntity<BankDTO> getBankByCode(@PathVariable("code") int code){
        log.info("Input to BankController.getBankByCode, code:{}", code);
        if(code <=0) {
            log.info("Invalid bank code");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BankDTO bankDTO = null;
         try{
            bankDTO = bankService.findBankDetails(code);

            if(bankDTO == null){
                log.info("Bank Details are not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            log.error("Exception while getting bank details by code", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

         return new ResponseEntity<BankDTO>(bankDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BankDTO> save(@RequestBody BankRequest bankRequest){
        log.info("Inside the BankController.save, bankRequest:{}", bankRequest);
        if(bankRequest == null){
            log.info("Invalid bank request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BankDTO bankDTO = null;
        try{
            bankDTO = bankService.save(bankRequest);
            log.info("Response, bankDTO:{}", bankDTO);
        }catch (Exception ex){
            log.error("Exception while getting bank details by code", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<BankDTO>(bankDTO, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<BankDTO> update(@RequestBody BankRequest bankRequest){
        log.info("Inside the BankController.update, bankRequest:{}", bankRequest);
        if(bankRequest == null){
            log.info("Invalid bank request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BankDTO bankDTO = null;
        try{
            bankDTO = bankService.save(bankRequest);
            log.info("Response, bankDTO:{}", bankDTO);
        }catch (Exception ex){
            log.error("Exception while getting bank details by code", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<BankDTO>(bankDTO, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("code") int code){
        log.info("Inside BankController.delete, bank code:{}", code);
        String response = null;
        if(code <=0){
            log.info("Invalid bank code");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            response = bankService.delete(code);
            log.info("Delete bank details, response:{}", response);
        }catch (Exception ex){
            log.error("Exception while deleting the bank details", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
