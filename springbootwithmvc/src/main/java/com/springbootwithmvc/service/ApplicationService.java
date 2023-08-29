package com.springbootwithmvc.service;

import com.springbootwithmvc.model.ApplicationDTO;
import com.springbootwithmvc.model.ApplicationRequest;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDTO> findAllApplication();

    ApplicationDTO save(ApplicationRequest applicationRequest);
}
