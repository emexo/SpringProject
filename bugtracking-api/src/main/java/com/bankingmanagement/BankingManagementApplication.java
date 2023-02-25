package com.bankingmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BankingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingManagementApplication.class, args);
		log.info("Banking Management application has been started");
	}

}
