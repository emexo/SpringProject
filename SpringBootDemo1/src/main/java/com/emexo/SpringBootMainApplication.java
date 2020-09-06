package com.emexo;

import com.emexo.entity.Application;
import com.emexo.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootMainApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringBootMainApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ApplicationRepository repository) {
		return (args) -> {
			//repository.save(new Application("Trackzilla","kesha.williams","Application for tracking bugs."));
			//repository.save(new Application("Expenses","mary.jones","Application to track expense reports."));
			//repository.save(new Application("Notifications","karen.kane","Application to send alerts and notifications to users."));

			for (Application application : repository.findAll()) {
				//log.info("The application is: " + application.toString());
			}

			for (Application application : repository.findByUserName("Expenses")) {
				log.info("The application is: " + application.toString());
			}

		};
	}
}
