package com.emexo.spring.annotation.properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.spring.annotation.properties");
        MailConfiguration configuration = context.getBean("mailConfiguration", MailConfiguration.class);
        configuration.getEmailConfiguration();
    }
}
