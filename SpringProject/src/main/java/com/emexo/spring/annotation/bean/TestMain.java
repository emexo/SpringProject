package com.emexo.spring.annotation.bean;

import com.emexo.spring.annotation.bean.Organization;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();

        context.scan("com.emexo.spring.annotation");
        context.refresh();

        Organization org = context.getBean("org", Organization.class);
        org.getOrgDetails();

    }
}
