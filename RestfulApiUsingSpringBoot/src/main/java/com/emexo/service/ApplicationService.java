package com.emexo.service;

import com.emexo.entity.Application;

import java.util.List;

public interface ApplicationService {
    List<ApplicationVO> listApplications();
    Application findApplication(long id);
    void save(Application application);
}


