package com.springproject.xml.di.constructor;

public class Student {
    private int studentId;
    private String studentName;
    private Marks marks;

    public Student(int studentId, String studentName, Marks marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    public void getStudentDetails(){
        System.out.println(studentId +" : "+ studentName);
        marks.getMarks();
    }
}
