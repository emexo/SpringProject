package com.emexo.service;

import com.emexo.entity.Application;
import com.emexo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) {
        Application application = applicationRepository.findById(id).get();
        return application;
    }

    @Override
    public void save(Application application) {
        applicationRepository.save(application);
    }




}
