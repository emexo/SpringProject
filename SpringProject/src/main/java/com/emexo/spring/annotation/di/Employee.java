package com.emexo.spring.annotation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employee")
public class Employee {

    @Value("10")
    int empId;

    @Value(value = "{Ajay, Rohan, Gary}")
    String empNames[];

    @Value(value = "{Etamin, Electra, PTP}")
    List<String> building;


    public Address address;

    @Autowired(required = false)
    public void setAddress(Address address) {
        this.address = address;
    }

    public void getEmployeedetails(){
        System.out.println("empId :" + empId);
        System.out.println("empNames :" + empNames[0]+":"+ empNames[1]+":"+ empNames[2]);
        System.out.println("building :" + building);

        address.getAddressSetails();
    }

}
