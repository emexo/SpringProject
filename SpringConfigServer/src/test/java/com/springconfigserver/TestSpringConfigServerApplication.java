package com.springconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringConfigServerApplication::main).with(TestSpringConfigServerApplication.class).run(args);
	}

}
