package com.bugtracking.service;

import com.bugtracking.entity.Application;
import com.bugtracking.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private static final Logger LOGGER= LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

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

    @Override
    public List<Application> findApplicationByName(String name) throws IllegalArgumentException {
        LOGGER.info("Input to ApplicationServiceImpl.findApplicationByName, name:{} ", name);
        if(name == null){
            throw new IllegalArgumentException("Invalid input");
        }
        Optional<List<Application>> application = applicationRepository.findAllByName(name);
        LOGGER.info("Find application by name response: {}", application.get());
        if (application.isPresent()){
            return application.get();
        }
        return null;
    }

    @Override
    public Application save(Application application) throws Exception {
        LOGGER.info("Input to ApplicationServiceImpl.save, application:{}", application);
        Application application1 = null;
        try {
            application1 = applicationRepository.save(application);
        } catch (Exception ex){
            LOGGER.error("Exception while saving application", ex);
            throw new Exception("Exception while saving application");
        }

        return application1;
    }

    public void delete(Long id){
        applicationRepository.deleteById(id);
    }


}
