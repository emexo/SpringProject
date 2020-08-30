package com.emexo.service;

import com.emexo.entity.Application;
import com.emexo.entity.Release;
import com.emexo.repository.ApplicationRepository;
import com.emexo.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@EnableRetry
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

    @Override
    @Retryable(value = {SQLException.class }, maxAttempts = 3)
    @Transactional
    public void save(Application application) throws InterruptedException {
        applicationRepository.save(application);
        Release release = new Release();
        release.setDescription("Test");
        //release.setDescription("Test Rollbackoooooooooooooooooooooooooooooooooooooooooooo");
        releaseRepository.save(release);
    }

    @Recover
    public String recover(SQLException t){
        return "Service recovered from failure.";
    }
}
