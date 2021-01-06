package com.emexo.repository;

import com.emexo.entity.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationRepositoryTest {
    @Autowired
    public ApplicationRepository applicationRepository;

    @Test
    //@Rollback(false)
    public void testSaveNewProduct() {
        Application application = applicationRepository.save(new Application("LRI","JPMC","Finance"));
        Application application1 = applicationRepository.findById(application.getId()).get();
        assertThat(application1.getName()).isEqualTo("LRI");
    }

}
