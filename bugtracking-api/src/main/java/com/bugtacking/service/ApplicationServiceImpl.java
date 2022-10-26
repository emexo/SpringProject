package com.bugtacking.service;

import com.bugtacking.entity.Application;
import com.bugtacking.exception.ApplicationNotFoundException;
import com.bugtacking.model.ApplicationRequest;
import com.bugtacking.model.ApplicationVO;
import com.bugtacking.repository.ApplicationRepository;
import org.hibernate.annotations.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService{
    private static final Logger LOGGER= LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public List<ApplicationVO> findAll() {
        LOGGER.info("Inside ApplicationServiceImpl.findAll");
        List<Application> applications =  applicationRepository.findAll();
        LOGGER.info("Find all application response: {}", applications);
        List<ApplicationVO> applicationVOS= applications.stream().map(application -> {
            ApplicationVO applicationVO = new ApplicationVO();
            applicationVO.setApplicationId(application.getApplicationId());
            applicationVO.setApplicationName(application.getApplicationName());
            applicationVO.setOwner(application.getOwner());
            applicationVO.setDescription(application.getDescription());
            return applicationVO;
        }).collect(Collectors.toList());
        return applicationVOS;
    }

    /**
     * Find the application by id
     * @param id
     * @return
     * @throws ApplicationNotFoundException
     */
    @Cacheable(value = "findbyid")
    @Async("asyncBean")
    @Override
    public CompletableFuture<ApplicationVO> findById(long id) throws ApplicationNotFoundException, InterruptedException {
        LOGGER.info("Inside ApplicationServiceImpl.findById and id: {}", id);
        Thread.sleep(6000l);
        ApplicationVO applicationVO = null;
        if(id < 0){
            LOGGER.info("Invalid application id:{}", id);
            throw new ApplicationNotFoundException("Application id is not valid");
        }
        Optional<Application> application = applicationRepository.findById(id);

        if(application.isPresent()) {
            LOGGER.info("Application details for the id: {} and the values :{}", id, application.get());
            applicationVO = new ApplicationVO();
            applicationVO.setApplicationId(application.get().getApplicationId());
            applicationVO.setApplicationId(application.get().getApplicationId());
            applicationVO.setApplicationName(application.get().getApplicationName());
            applicationVO.setOwner(application.get().getOwner());
            applicationVO.setDescription(application.get().getDescription());
        }
        return CompletableFuture.completedFuture(applicationVO);
    }

    /**
     * Find application by name
     * @param name
     * @return
     * @throws ApplicationNotFoundException
     */
    @Cacheable("findbyname")
    @Async("asyncBean")
    @Override
    public CompletableFuture<ApplicationVO> findByName(String name) throws ApplicationNotFoundException, InterruptedException {
        LOGGER.info("Inside ApplicationServiceImpl.findByName and name: {}", name);
        Thread.sleep(6000l);
        ApplicationVO applicationVO = null;
        if(name == null){
            LOGGER.info("Invalid application name:{}", name);
            throw new ApplicationNotFoundException("Application id is not valid");
        }
        Optional<Application> application = applicationRepository.findApplicationByName(name);

        if(application.isPresent()) {
            LOGGER.info("Application details for the name {} and the values :{}", name, application.get());
            applicationVO = new ApplicationVO();
            applicationVO.setApplicationId(application.get().getApplicationId());
            applicationVO.setApplicationId(application.get().getApplicationId());
            applicationVO.setApplicationName(application.get().getApplicationName());
            applicationVO.setOwner(application.get().getOwner());
            applicationVO.setDescription(application.get().getDescription());
        }
        return CompletableFuture.completedFuture(applicationVO);
    }

    /**
     * Save application details
     * @param applicationRequest
     * @return
     */
    public ApplicationVO save(ApplicationRequest applicationRequest) throws ApplicationNotFoundException {
        LOGGER.info("Inside the ApplicationServiceImpl.save method and params, applicationRequest:{}", applicationRequest);

        if(applicationRequest == null){
            LOGGER.info("Invalid application request");
            throw new ApplicationNotFoundException("Invalid application request");
        }

        Application application = new Application();
        if(applicationRequest.getApplicationId() >0){
            application.setApplicationId(applicationRequest.getApplicationId());
        }
        application.setApplicationName(applicationRequest.getApplicationName());
        application.setDescription(applicationRequest.getDescription());
        application.setOwner(applicationRequest.getOwner());

        Application applicationResponse = applicationRepository.save(application);
        ApplicationVO applicationVO = null;
        if(applicationResponse != null) {
            LOGGER.info("Application Response, applicationResponse:{}", applicationResponse);
            applicationVO = new ApplicationVO();
            applicationVO.setApplicationId(application.getApplicationId());
            applicationVO.setApplicationId(application.getApplicationId());
            applicationVO.setApplicationName(application.getApplicationName());
            applicationVO.setOwner(application.getOwner());
            applicationVO.setDescription(application.getDescription());
        }
        return applicationVO;
    }

    /**
     * Delete application by id
     * @param id
     * @return
     * @throws ApplicationNotFoundException
     */
    public String delete(long id) throws ApplicationNotFoundException {
        LOGGER.info("Input to AppplicationServiceImpl.delete, id:{}", id);
        if(id<0){
            LOGGER.info("Invalid application id");
            throw new ApplicationNotFoundException("Invalid application id");
        }
        try {
            applicationRepository.deleteById(id);
        }catch (Exception ex){
            LOGGER.error("Exception while deleting application");
            throw new ApplicationNotFoundException("Exception while deleting application");
        }
        return "Application has been deleted";
    }

    @CacheEvict(value = "findbyname",allEntries = true)
    public void clearFindByNameCache(){

    }

    @CacheEvict(value = "findbyid", allEntries = true)
    public void clearFindByIdcCache(){

    }
}
