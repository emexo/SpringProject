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

    //https://localhost:8080/api/v1/applications
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

    //https://localhost:8080/api/v1/applications/1
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id) {
        LOGGER.info("Inside ApplicationsController.getApplication, id :{}", id);
        try {
            return new ResponseEntity<Application>(applicationService.findApplication(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //https://localhost:8080/api/v1/applications?name=appname&id=1
    @GetMapping("/name")
    public ResponseEntity<List<Application>> getApplicationByName(@RequestParam("name") String appName, @RequestParam("id") int id) {
        LOGGER.info("Inside ApplicationsController.getApplication, appName :{}", appName);
        try {
            return new ResponseEntity<List<Application>>(applicationService.findApplicationByName(appName), HttpStatus.OK);
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

    @PutMapping
    public ResponseEntity<String> updateApplication(@RequestBody  Application application) {
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
