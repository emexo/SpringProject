package com.tim.util;

import java.net.URI;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tim.domain.Course;

public class CourseUtil {
	
public void getAllCourseUtil() {
	RestTemplate template=new RestTemplate();
	String courseUrl="http://localhost:8080/course/getAll";
	String result=template.getForObject(courseUrl, String.class);
	System.out.println(result);
}
public void getByIdCourseUtil() {
	RestTemplate template=new RestTemplate();
	String courseUrl="http://localhost:8080/course/getById?courseId=5";
	String result=template.getForObject(courseUrl, String.class);
	System.out.println(result);
}
public void saveCourseUtil() {
	RestTemplate template=new RestTemplate();
	final String courseUrl="http://localhost:8080/course/save";
	try {
	URI uri=new URI(courseUrl);
	Course course=new Course();
	course.setCourseName("Java");
	course.setCourseDesc("Core Java,J2EE");
	course.setCredits("10%");
	course.setDate(new Date());
	course.setDuration("1 month");
	course.setFee(9000);
	
	HttpHeaders header=new HttpHeaders();
	HttpEntity<Course> entity=new HttpEntity<Course>(course,header);
	ResponseEntity<String> response=template.postForEntity(uri, entity, String.class);
	System.out.println(response);
}catch(Exception e) {
	e.printStackTrace();
}
}
public void updateCourseUtil() {
	RestTemplate template=new RestTemplate();
	final String courseUrl="http://localhost:8080/course/update";
	try {
	URI uri=new URI(courseUrl);
	Course course=new Course();
	course.setCourseId(5);
	course.setCourseName("Spring");
	course.setDuration("2 month");

	
	HttpHeaders header=new HttpHeaders();
	HttpEntity<Course> entity=new HttpEntity<Course>(course,header);
	template.put(uri, entity);
	System.out.println("Record Updated Successfully");
}catch(Exception e) {
	e.printStackTrace();
}
}
public void deleteCourseByIdUtil() {
	RestTemplate template=new RestTemplate();
	final String courseUrl="http://localhost:8080/course/delete/5";
	try {
		URI uri=new URI(courseUrl);
		template.delete(uri);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
