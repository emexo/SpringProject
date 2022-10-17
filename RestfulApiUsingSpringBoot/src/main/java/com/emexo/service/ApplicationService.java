package com.emexo.service;

import com.emexo.entity.Application;

import java.util.List;

public interface ApplicationService {
    List<ApplicationVO> findAll();
     public ApplicationVO findById(long id) throws ApplicationException;
    void save(Application application);
}


