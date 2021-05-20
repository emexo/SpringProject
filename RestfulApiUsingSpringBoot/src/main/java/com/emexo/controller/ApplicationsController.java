package com.emexo.controller;

import com.emexo.FundamentalsApplication;
import com.emexo.entity.Application;
import com.emexo.exception.ApplicationNotFoundException;
import com.emexo.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationsController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ApplicationsController.class);

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        LOGGER.info("Inside the ApplicationsController.getAllApplications");

        try {
            List<Application> list = applicationService.listApplications();
            LOGGER.info("Response from get applications:{} : ", list);
            return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
        } catch(Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id) {
        LOGGER.info("Inside ApplicationsController.getApplication, id :{}", id);
        try {
            return new ResponseEntity<Application>(applicationService.findApplication(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveApplication(@RequestBody  Application application) {
        LOGGER.info("Inside ApplicationController.saveApplication, application:{}", application);
        try {
            applicationService.save(application);
        } catch (ApplicationNotFoundException ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Application has been saved", HttpStatus.OK);
    }
}
