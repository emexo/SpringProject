package com.emexo.spring.jdbc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springjdbctemplate-application.xml");
        contactDAO contactDAO = (contactDAO) context.getBean("contactDAO");

        //save
        int response = contactDAO.save("Tom", "tomea@mail.com", "USA", "12345");
        System.out.println("Save: " + response);

        // get All
        List<Contact> contactList = contactDAO.getAll();

        // get all the records
        contactList.forEach(contact -> {
            System.out.println(contact.getName() +":"+
                    contact.getTelephone()+":"+
                    contact.getAddress()+":"+
                    contact.getEmail());
        });

    }
}
