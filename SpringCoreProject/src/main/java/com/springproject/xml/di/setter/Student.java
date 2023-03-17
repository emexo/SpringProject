package com.springproject.xml.di.setter;

public class Student {
    private int studentId;
    private String studentName;
    private Marks marks;


    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public void getStudentDetails(){
        System.out.println(studentId +" : "+ studentName);
        marks.getMarks();
    }
}
