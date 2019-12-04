package com.tim.util;

import java.net.URI;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tim.domain.Course;
import com.tim.domain.Student;

public class StudentUtil {
	public void getAllStudentUtil() {
		RestTemplate template=new RestTemplate();
		String studentUrl="http://localhost:8080/student/getAll";
		String result=template.getForObject(studentUrl, String.class);
		System.out.println(result);
	}
	public void getByIdStudentUtil() {
		RestTemplate template=new RestTemplate();
		String studentUrl="http://localhost:8080/student/getById?studentId=1";
		String result=template.getForObject(studentUrl, String.class);
		System.out.println(result);
	}
	public void saveStudentUtil() {
		RestTemplate template=new RestTemplate();
		final String studentUrl="http://localhost:8080/student/save";
		try {
		URI uri=new URI(studentUrl);
		Student student=new Student();
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setAvailability("Weekend");
		student.setCourse("Java");
		student.setDate(new Date());
		student.setEmailId("tony@gmail.com");
		student.setGender("M");
		student.setMobile("9966332211");
		student.setMode("Classroom");
		student.setExperience("2 years");
		
		HttpHeaders header=new HttpHeaders();
		HttpEntity<Student> entity=new HttpEntity<Student>(student,header);
		ResponseEntity<String> response=template.postForEntity(uri, entity, String.class);
		System.out.println(response);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void updateCourseUtil() {
		RestTemplate template=new RestTemplate();
		final String studentUrl="http://localhost:8080/student/update";
		
		try {
			URI uri=new URI(studentUrl);
			Student student=new Student();
			student.setStudentId(1);
			student.setFirstName("Tony");
			student.setLastName("Stark");

		
		HttpHeaders header=new HttpHeaders();
		HttpEntity<Student> entity=new HttpEntity<Student>(student,header);
		template.put(uri, entity);
		System.out.println("Record Updated Successfully");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void deleteStudentByIdUtil() {
		RestTemplate template=new RestTemplate();
		final String studentUrl="http://localhost:8080/student/delete/5";
		try {
			URI uri=new URI(studentUrl);
			template.delete(uri);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
