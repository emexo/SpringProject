package com.springbootwithmvc.service;

import com.springbootwithmvc.entity.Application;
import com.springbootwithmvc.model.ApplicationDTO;
import com.springbootwithmvc.model.ApplicationRequest;
import com.springbootwithmvc.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<ApplicationDTO> findAllApplication() {
        List<Application> applications =  applicationRepository.findAll();

        if(CollectionUtils.isEmpty(applications)){
            return null;
        }
        List<ApplicationDTO> applicationDTOS =  applications.stream().map( application -> {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setApplicationId(application.getApplicationId());
            applicationDTO.setApplicationName(application.getApplicationName());
            applicationDTO.setDescription(application.getDescription());
            applicationDTO.setOwner(application.getOwner());
            return applicationDTO;
        }).collect(Collectors.toList());

        return applicationDTOS;
    }

    @Override
    public ApplicationDTO save(ApplicationRequest applicationRequest) {
        Application application = new Application();
        application.setApplicationName(applicationRequest.getApplicationName());
        application.setDescription(applicationRequest.getDescription());
        application.setOwner(applicationRequest.getOwner());

        Application application1=  applicationRepository.save(application);

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setApplicationId(application1.getApplicationId());
        applicationDTO.setApplicationName(application1.getApplicationName());
        applicationDTO.setDescription(application1.getDescription());
        applicationDTO.setOwner(application1.getOwner());
        return applicationDTO;
    }
}
