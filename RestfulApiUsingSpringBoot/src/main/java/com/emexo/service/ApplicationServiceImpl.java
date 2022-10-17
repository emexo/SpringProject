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
    
      /**
     * Find the application by id
     * @param id
     * @return
     * @throws ApplicationException
     */
    @Override
    public ApplicationVO findById(long id) throws ApplicationException{
        LOGGER.info("Inside ApplicationServiceImpl.findById and id: {}", id);
        ApplicationVO applicationVO = null;
        if(id < 0){
            LOGGER.info("Invalid application id:{}", id);
            throw new ApplicationException("Application id is not valid");
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
        return applicationVO;
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
