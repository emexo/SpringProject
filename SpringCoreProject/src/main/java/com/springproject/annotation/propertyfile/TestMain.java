package com.emexo.annotation.propertyfile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.annotation.propertyfile");

        MailConfiguration configuration = context.getBean("mailConfiguration", MailConfiguration.class);

        configuration.getMailConfiguration();
    }
}
