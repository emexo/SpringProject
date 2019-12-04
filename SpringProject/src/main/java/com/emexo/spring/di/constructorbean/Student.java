package com.emexo.spring.di.constructorbean;

public class Student {
    private int studentId;
    private String studentName;
    private String address;
    private Marks marks;

    public Student(int studentId, String studentName, String address, Marks marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.marks = marks;
    }

    public void getStudentDetails() {
        System.out.println("studentId: " + studentId);
        System.out.println("studentName: " + studentName);
        System.out.println("address: " + address);
        marks.getMarksDetails();


    }
}
