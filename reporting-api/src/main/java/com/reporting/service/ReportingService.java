package com.reporting.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reporting.model.ApplicationRequest;
import com.reporting.model.ApplicationVO;

import java.net.URISyntaxException;
import java.util.List;

public interface ReportingService {
     List<ApplicationVO> findAll();
     ApplicationVO findById(long id);
     ApplicationVO save(ApplicationRequest request);
     public List<ApplicationVO> findAllNew() throws JsonProcessingException, URISyntaxException, Exception;
     ApplicationVO saveNew(ApplicationRequest request) throws URISyntaxException;
}
