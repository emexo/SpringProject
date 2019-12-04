package com.tim.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tim.dao.StudentDao;
import com.tim.domain.Student;
import com.tim.service.TimService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private TimService timService;
	private static final Logger LOGGER = LogManager.getLogger(StudentController.class.getName());
// http://localhost:8080/student/save
	/*
	 * {"firstName":"Shobana", "lastName":"Vasudevan", "mobile":"9988774455",
	 * "emailId":"geetha@gmail.com", "gender":"F", "experince":"5 years",
	 * "course":"Spring", "availability":"Weekday", "mode":"classroom" }
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveStudent(@RequestBody Student student) {
		try {
		timService.insertStudent(student);
		LOGGER.info("Record Inserted Successfully");
		}catch(Exception e) {
			LOGGER.error("Record Not Inserted",e);
		}
		return "Record inserted successfully";
	}
	// http://localhost:8080/student/delete/2
	@RequestMapping(value="/delete/{studentId}", method=RequestMethod.DELETE)
	public String deleteStudent(@PathVariable int studentId) {
		int result=0;
		try {
		result=timService.deleteStudent(studentId);
		LOGGER.info("Record Deleted Successfully", result);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return "Record Deleted Successfully";
	}
	// http://localhost:8080/student/update
	/*
	 * {"studentId":2, "firstName":"Shobana", "lastName":"Vasudevan"
	 * 
	 * }
	 */
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public String updateStudent(@RequestBody Student student) {
		int result=0;
		try {
			result=timService.updateStudent(student);
			LOGGER.info("Record Updated Successfully", result);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return "Records Updated Successfully";
	}
	// http://localhost:8080/student/getAll
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Student> getAllStudents(){
		List<Student> studentList=new ArrayList<Student>();
		try {
			studentList=timService.getAllStudents();
			LOGGER.info("Fetched Records", studentList);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return studentList;
	}
	// http://localhost:8080/student/getById?studentId=2
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	public Student getStudentById(@RequestParam("studentId")int studentId) {
		Student student=new Student();
		try {
			student=timService.getStudentById(studentId);
			LOGGER.info("Fetched Records", student);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return student;
	}
}
	
	
	
	
	
	
	
