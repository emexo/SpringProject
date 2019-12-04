package com.emexo.spring.ioc.applicationcontext.filesystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class  TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\Regu\\G\\IntellijWorkspace\\Emexo\\SpringProject\\src\\main\\resources\\filesystemapplicationcontext.xml");

        Organization organization = context.getBean("organization", Organization.class);
        organization.getOrganizationDetails();

            }
}
