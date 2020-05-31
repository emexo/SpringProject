package com.emexo.service;

import com.emexo.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();

    void save(Application application);
}


