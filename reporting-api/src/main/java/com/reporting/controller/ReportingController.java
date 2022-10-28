package com.reporting.controller;

import com.reporting.model.ApplicationVO;
import com.reporting.service.ReportingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportingController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ReportingController.class);

    @Autowired
    ReportingService reportingService;

    @GetMapping
    public ResponseEntity<List<ApplicationVO>> getApplications(){
        LOGGER.info("Inside the ApplicationController.getApplications");
        List<ApplicationVO> applicationVOS = null;
        try {
            applicationVOS = reportingService.findAll();
            LOGGER.info("Application response:{}", applicationVOS );
            if(CollectionUtils.isEmpty(applicationVOS)){
                LOGGER.info("Application details are not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            LOGGER.error("Exception while calling getApplications", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<ApplicationVO>>(applicationVOS, HttpStatus.OK);
    }
}
