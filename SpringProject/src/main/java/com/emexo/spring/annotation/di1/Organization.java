package com.emexo.spring.annotation.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;


@Component
public class Organization {
    @Value("Infy")
    private String OrgName;

    @Value("Narayana Murthy")
    private String ceoName;

    @Value("2000")
    private int established;

    @Autowired
    private Employee employee;

    @Qualifier("address")
    @Autowired(required = false)
    private Address address;

    public void getOrgDetails() {
        System.out.println("OrgName : " + OrgName);
        System.out.println("ceoName : " + ceoName);
        System.out.println("established : " + established);

        employee.getEmployeedetails();
        address.getAddressSetails();
    }

    @PostConstruct
    public void init(){
        System.out.println("###Post Construct###");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("###Pre Destroy###");
    }
}
