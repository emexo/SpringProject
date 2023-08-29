package com.springbootwithmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringbootwithmvcApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringbootwithmvcApplication::main).with(TestSpringbootwithmvcApplication.class).run(args);
	}

}
