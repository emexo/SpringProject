package com.springproject.annotation.bean;

import org.springframework.stereotype.Service;

@Service
public class Student {
    private int studentId;
    private String studentName;

    public Student(){
        this.studentId=1;
        this.studentName="Ajay";
    }

    public void getStudentDetails(){
        System.out.println(studentId);
        System.out.println(studentName);
    }
}
