package com.springproject.annotation.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.springproject.annotation");
        context.refresh();

        Organization organization = context.getBean("organization", Organization.class);
        organization.getOrgDetails();
    }
}
