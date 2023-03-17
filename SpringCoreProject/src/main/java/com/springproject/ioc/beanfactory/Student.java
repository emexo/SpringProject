package com.springproject.ioc.beanfactory;

public class Student {
    private int studentId;
    private String studentName;

    public Student() {
        System.out.println("Default constructor");
        this.studentId = 1;
        this.studentName = "Paras";
    }

    public void getStudentDetails(){
        System.out.println(studentId);
        System.out.println(studentName);
    }
}
