package com.emexo.spring.di.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class College {
    private List<String> staffName;
    private Set<String> depName;
    String colors[];
    Map<String,String> faculties;
    Properties capitals;

    public void setStaffName(List<String> staffName) {
        this.staffName = staffName;
    }

    public void setDepName(Set<String> depName) {
        this.depName = depName;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public void setFaculties(Map faculties) {
        this.faculties = faculties;
    }

    public void setCapitals(Properties capitals) {
        this.capitals = capitals;
    }

    public void getCollegeDetails(){
        System.out.println("staffName : " + staffName);
        System.out.println("depName : " + depName);
        System.out.println("colors : " + colors[0] +":" + colors[1]);
        System.out.println("faculties : " + faculties);
        System.out.println("staffName : " + capitals);
    }
}
