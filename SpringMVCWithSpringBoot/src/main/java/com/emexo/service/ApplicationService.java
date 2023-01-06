package com.emexo.service;

import com.emexo.entity.Application;

import java.sql.SQLException;

public interface ApplicationService {
    Iterable<Application> listApplications();

    void save(Application application) throws SQLException;

    public void delete(int id);

    public Application getApplication(int id);
}


