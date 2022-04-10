package com.emexo.spring.jdbc.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.spring.jdbc.annotation");
        ContactDAO contactDAO = context.getBean("contactDAO", ContactDAO.class);

        Contact contact = new Contact();
        contact.setEmail("regu@gmail.com");
        contact.setTelephone("99799897");

        contactDAO.saveContact(contact);
    }
}
