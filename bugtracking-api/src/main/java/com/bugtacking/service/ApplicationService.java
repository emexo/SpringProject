package com.bugtacking.service;

import com.bugtacking.entity.Application;
import com.bugtacking.exception.ApplicationNotFoundException;
import com.bugtacking.model.ApplicationRequest;
import com.bugtacking.model.ApplicationVO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ApplicationService {

    List<ApplicationVO> findAll();
    CompletableFuture<ApplicationVO> findById(long id) throws ApplicationNotFoundException, InterruptedException;
    CompletableFuture<ApplicationVO>  findByName(String name) throws ApplicationNotFoundException, InterruptedException;
    ApplicationVO save(ApplicationRequest application) throws ApplicationNotFoundException;
    String delete(long id) throws ApplicationNotFoundException;
    void clearFindByNameCache();
    void clearFindByIdcCache();
}
