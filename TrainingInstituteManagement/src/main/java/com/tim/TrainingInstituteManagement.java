package com.tim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.context.ApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication
public class TrainingInstituteManagement {
	private static final Logger LOGGER = LogManager.getLogger(TrainingInstituteManagement.class.getName());
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TrainingInstituteManagement.class, args);
		//LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info(" Spring Boot Application Started!!!");
        //LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
        

	}

}
