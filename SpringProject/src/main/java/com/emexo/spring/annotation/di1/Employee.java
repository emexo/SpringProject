package com.emexo.spring.annotation.di1;

import com.emexo.spring.annotation.di.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Employee {

    @Value("10")
    int empId;

    @Value(value = "{Ajay, Rohan, Gary}")
    String empNames[];

    @Value(value = "{Etamin, Electra, PTP}")
    List<String> building;

    public void getEmployeedetails(){
        System.out.println("empId :" + empId);
        System.out.println("empNames :" + empNames[0]+":"+ empNames[1]+":"+ empNames[2]);
        System.out.println("building :" + building);
    }

}
