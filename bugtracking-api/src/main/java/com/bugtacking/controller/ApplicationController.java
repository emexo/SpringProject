package com.bugtacking.controller;

import com.bugtacking.BugtrackingApiApplication;
import com.bugtacking.exception.ApplicationNotFoundException;
import com.bugtacking.model.ApplicationRequest;
import com.bugtacking.model.ApplicationVO;
import com.bugtacking.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/applications")
public class ApplicationController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationVO>> getApplications(){
        LOGGER.info("Inside the ApplicationController.getApplications");
        List<ApplicationVO> applicationVOS = null;
        try {
            applicationVOS = applicationService.findAll();
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
        //http://localhost:9090/api/v1/applications/1
        //http://localhost:9090/api/v1/applications?id=1&name=appname
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationVO> getApplicationById(@PathVariable("id") long id){
        LOGGER.info("Inside the ApplicationController.getApplications");
       ApplicationVO applicationVO = null;
        try {
            //applicationVO = applicationService.findById(id);
            LOGGER.info("Application response:{}", applicationVO );
            if(applicationVO == null){
                LOGGER.info("Application details are not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            LOGGER.error("Exception while calling getApplications", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ApplicationVO>(applicationVO, HttpStatus.OK);
    }

    /**
     * Find application by name
     * @param name
     * @return
     */
    @GetMapping("/name")
    public ResponseEntity<ApplicationVO> getApplicationByName(@RequestParam("name") String name){
        LOGGER.info("Inside the ApplicationController.getApplicationByName");
        ApplicationVO applicationVO = null;
        try {
            //applicationVO = applicationService.findByName(name);
            LOGGER.info("Application response:{}", applicationVO );
            if(applicationVO == null){
                LOGGER.info("Application details are not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            LOGGER.error("Exception while calling getApplications", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ApplicationVO>(applicationVO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApplicationVO> save(@RequestBody ApplicationRequest applicationRequest){
        LOGGER.info("Inside ApplicationController.save and applicationVO;{}", applicationRequest);
        if(applicationRequest == null){
            LOGGER.info("Invalid Application request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ApplicationVO applicationVO = null;
        try {
            applicationVO = applicationService.save(applicationRequest);
            if(applicationVO == null){
                LOGGER.info("Application details are not saved");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception ex){
          LOGGER.error("Exception while saving application");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ApplicationVO>(applicationVO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApplicationVO> update(@RequestBody ApplicationRequest applicationRequest){
        LOGGER.info("Inside ApplicationController.update and applicationVO;{}", applicationRequest);
        if(applicationRequest == null){
            LOGGER.info("Invalid Application request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ApplicationVO applicationVO = null;
        try {
            applicationVO = applicationService.save(applicationRequest);
            if(applicationVO == null){
                LOGGER.info("Application details are not saved");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception ex){
            LOGGER.error("Exception while saving application");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ApplicationVO>(applicationVO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") long id){
        LOGGER.info("Input to ApplicationController.delete, id:{}", id);
        String response = null;
        try{
            response = applicationService.delete(id);
        }catch (Exception ex){
            LOGGER.error("Exception while saving application");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String >(response, HttpStatus.OK);
    }

    @GetMapping("/byid")
    public ResponseEntity<ApplicationVO> getApplicationByIdWithExceptionHandler(@RequestParam("id") long id) throws  ApplicationNotFoundException{
        LOGGER.info("Inside the ApplicationController.getApplications");
        ApplicationVO applicationVO = null;
        try {
           // applicationVO = applicationService.findById(id);
            LOGGER.info("Application response:{}", applicationVO );
            if(applicationVO == null){
                LOGGER.info("Application details are not found");
                throw new ApplicationNotFoundException("Application details are not found");
            }
        }catch (Exception ex){
            LOGGER.error("Exception while calling getApplications", ex);
            throw new ApplicationNotFoundException(ex);
        }

        return new ResponseEntity<ApplicationVO>(applicationVO, HttpStatus.OK);
    }


    @GetMapping("/byidandname") //12132ms 6112 ms
    public ResponseEntity<List<ApplicationVO>> getApplicationByIdAndName(@RequestParam("id") long id, @RequestParam("name") String name){
        LOGGER.info("Inside the ApplicationController.getApplications");
        CompletableFuture<ApplicationVO> applicationVO = null;
        CompletableFuture<ApplicationVO> applicationVO1 = null;
        List<ApplicationVO> applicationVOS = new ArrayList<>();
        try {
            applicationVO = applicationService.findById(id);
            LOGGER.info("Get application by id response:{}", applicationVO );
            applicationVO1 = applicationService.findByName(name);
            LOGGER.info("Get application by name response:{}", applicationVO1);

            CompletableFuture.allOf(applicationVO, applicationVO1).join();

            applicationVOS.add(applicationVO.get());
            applicationVOS.add(applicationVO1.get());
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

    @GetMapping("/clearcache")
    public ResponseEntity<String> clearCache(){
        try {
            applicationService.clearFindByIdcCache();
            applicationService.clearFindByNameCache();
        }catch (Exception ex){
            LOGGER.error("Exception while calling getApplications", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>("Cache has been deleted", HttpStatus.OK);
    }

}
