package com.bugtacking.repository;

import com.bugtacking.entity.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationRepositoryTest {

    @Autowired
    public ApplicationRepository applicationRepository;

    @Test
    public void testFindAll(){
        saveApplication();
        List<Application> applicationList = applicationRepository.findAll();
        assertEquals(1, applicationList.size());
    }

    @Test
    public void testFindByApplicationName(){
        saveApplication();
        Application application = applicationRepository.findApplicationByName("Digital Banking").get();
        assertEquals("Digital Banking", application.getApplicationName());
    }

    public void saveApplication(){
        Application application = new Application();
        application.setApplicationName("Digital Banking");
        application.setDescription("Online banking");
        application.setOwner("JPMC");
        applicationRepository.save(application);
    }
}
