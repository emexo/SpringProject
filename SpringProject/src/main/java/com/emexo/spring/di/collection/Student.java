package com.emexo.spring.di.collection;

public class Student {
    private int studentId;
    private String studentName;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void getEmployeeDetails(){
        System.out.println("Emp Id : " + studentId);
        System.out.println("Emp Name : " + studentName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
