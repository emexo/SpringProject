package com.bugtacking.service;

import com.bugtacking.entity.Application;
import com.bugtacking.model.ApplicationVO;
import com.bugtacking.repository.ApplicationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplTest {

    @Mock
    ApplicationRepository applicationRepository;

    @InjectMocks
    ApplicationServiceImpl applicationService;

    @Test
    public void testFindAll(){
        List<Application> applications = new ArrayList<>();
        Application application = new Application();
        application.setApplicationId(1);
        application.setApplicationName("Liquidity Risk Management");
        application.setOwner("JP Morgan");
        application.setDescription("Risk Management");
        applications.add(application);

        when(applicationRepository.findAll()).thenReturn(applications);
        List<ApplicationVO> applicationVOS= applicationService.findAll();
        assertEquals(1, applicationVOS.size());

    }
}
