package com.emexo.spring.di.setterbean;

public class Student {
    private int studentId;
    private String studentName;
    private String address;
    private Marks marks;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public void getStudentDetails() {
        System.out.println("studentId: " + studentId);
        System.out.println("studentName: " + studentName);
        System.out.println("address: " + address);
        marks.getMarksDetails();


    }
}
