package com.emexo.spring.inheritance;

public class Elephant extends Animal {
    private String location;

    public Elephant() {
        System.out.println("Elephant constructor");
    }

    public void initElephant() {
        System.out.println("Inside initE()");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void destroyElephant() {
        System.out.println("Destroy Method");
    }
}
