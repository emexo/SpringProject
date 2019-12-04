package com.tim.dao;

import java.util.List;

import com.tim.domain.Course;
import com.tim.domain.Registration;

public interface CourseDao {
	public void insertCourse(Course course);
	public int deleteCourse(int courseId) ;
	public int updateCourse(Course course);
	public List<Course> getAllCourse() ;
	public Course getCourseById(int courseId);
}
