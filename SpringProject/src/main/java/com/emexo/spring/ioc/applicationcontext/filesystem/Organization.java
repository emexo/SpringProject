package com.emexo.spring.ioc.applicationcontext.filesystem;

public class Organization {
    private String OrganizationName = "JPMC";
    private int established = 2010;
    private String CEO ="JP Morgan";

    public void getOrganizationDetails(){
        System.out.println(OrganizationName);
        System.out.println(established);
        System.out.println(CEO);
    }
}
