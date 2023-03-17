package com.springproject.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Organization {

    @Value("Intel")
    private String orgName;

    @Value("1990")
    private int estYear;

    @Value(value = "{Ajay, Rohan, Gary}")
    private String boardMembers[];

    @Value(value = "{Etamin, Electra, PTP}")
    private List<String> building;

    @Autowired
    private Employee employee;

    public void getOrgDetails(){
        employee.getEmployeeDetails();
        System.out.println(orgName);
        System.out.println(estYear);
        System.out.println(boardMembers);
        System.out.println(building);
    }
}
