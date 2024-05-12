package com.springconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringConfigClientApplication::main).with(TestSpringConfigClientApplication.class).run(args);
	}

}
