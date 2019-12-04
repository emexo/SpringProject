package com.emexo.spring.mail.properties;

import com.emexo.spring.ioc.applicationcontext.classpath.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mailconfiguration.xml");

        MailConfiguration mail = context.getBean("mail", MailConfiguration.class);
        mail.getEmailConfiguration();

    }
}
