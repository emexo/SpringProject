package com.reporting.service;

import com.reporting.model.ApplicationVO;

import java.util.List;

public interface ReportingService {
     List<ApplicationVO> findAll();
     ApplicationVO findById(long id);
}
