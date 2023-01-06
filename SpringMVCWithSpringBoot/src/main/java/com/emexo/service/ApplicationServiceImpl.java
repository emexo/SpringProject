package com.emexo.service;

import com.emexo.entity.Application;
import com.emexo.entity.Release;
import com.emexo.repository.ApplicationRepository;
import com.emexo.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
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
    @Retryable(value = {SQLException.class }, maxAttempts = 3,  backoff = @Backoff(delayExpression = "6000"))
    public void save(Application application) throws SQLException {
        applicationRepository.save(application);
    }

    public void delete(int id){
        applicationRepository.deleteById(id);
    }

    public Application getApplication(int id){
        return applicationRepository.findById(id).get();
    }

    @Recover
    public String recover(SQLException t, Application application){
        System.out.println("########### Recovery ##########");
        return "Service recovered from failure.";
    }
}
