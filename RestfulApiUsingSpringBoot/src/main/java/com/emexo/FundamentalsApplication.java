package com.emexo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FundamentalsApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(FundamentalsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
		LOGGER.debug("Debug Message Logged !!!");
		LOGGER.info("Info Message Logged !!!");
		LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
	}
}
