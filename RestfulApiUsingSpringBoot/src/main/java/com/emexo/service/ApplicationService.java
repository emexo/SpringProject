package com.emexo.service;

import com.emexo.entity.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> listApplications();
    Application findApplication(long id);
}


