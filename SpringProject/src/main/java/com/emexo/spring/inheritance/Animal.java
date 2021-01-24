package com.emexo.spring.inheritance;

public class Animal {
    private String name;
    private Integer age;

    public Animal() {
        System.out.println("Animal Constructor");
    }

    public void initA() {
        System.out.println("Inside initA()");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
