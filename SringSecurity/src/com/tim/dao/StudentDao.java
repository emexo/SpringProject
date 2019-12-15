package com.tim.dao;

import java.util.List;

import com.tim.domain.Student;


public interface StudentDao {
	public void insertStudent(Student student);
	public int deleteStudent(int studentId) ;
	public int updateStudent(Student student);
	public List<Student> getAllStudents() ;
	public Student getStudentById(int studentId);
}
