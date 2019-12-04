package com.emexo.spring.annotation.bean;

import org.springframework.stereotype.Component;

@Component("org")
public class Organization {

    private String OrgName="Infy";
    private String ceoName ="NMurthy";
    private int established= 2000;

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public void setEstablished(int established) {
        this.established = established;
    }

    public void getOrgDetails(){
        System.out.println("OrgName : " + OrgName);
        System.out.println("ceoName : " + ceoName);
        System.out.println("established : " + established);
    }
}
