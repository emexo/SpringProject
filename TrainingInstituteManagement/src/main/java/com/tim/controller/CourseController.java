package com.tim.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tim.TrainingInstituteManagement;
import com.tim.domain.Course;
import com.tim.service.TimService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private TimService timService;
	
	private static final Logger LOGGER = LogManager.getLogger(CourseController.class.getName());

	// http://localhost:8080/course/save
	/*
	 * { "courseName": "Python", "duration": "2 Months", "fee": "10000",
	 * "courseDesc": "Python Core and Advance", "credits": "25%" }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCourse(@RequestBody Course course) {
		try {
			timService.insertCourse(course);
			LOGGER.info("Record Inserted Successfully");

		} catch (Exception e) {
			LOGGER.error("Error Inserting Records", e);
		}
		return "Record inserted successfully";
	}

//	http://localhost:8080/course/delete/1
	@RequestMapping(value = "/delete/{courseId}", method = RequestMethod.DELETE)
	public String deleteCourse(@PathVariable("courseId") int courseId) {
		int result = 0;
		try {
			result = timService.deleteCourse(courseId);
			LOGGER.info("Record Deleted Successfully", result);
		} catch (Exception e) {
			LOGGER.error("No Record found", e);
		}
		return "Record Deleted Successfully";
	}
	// http://localhost:8080/course/update
	// { "courseId:"2","courseName": "Python", "duration": "2 Months" }

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateCourse(@RequestBody Course course) {
		int result = 0;
		try {
			result = timService.updateCourse(course);
			LOGGER.info("Records Updated Successfully", result);
		} catch (Exception e) {
			LOGGER.error("Record Not Updated", e);
		}
		return "Records Updated Successfully";

	}

	// http://localhost:8080/course/getAll
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Course> getAllCourse() {
		List<Course> courseList = new ArrayList<Course>();
		try {
			courseList = timService.getAllCourse();
			LOGGER.info("Fetched Records", courseList);
		} catch (Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return courseList;
	}

	// http://localhost:8080/course/getById?courseId=1
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public Course getCourseById(@RequestParam("courseId") int courseId) {

		Course course = new Course();
		try {
			course = timService.getCourseById(courseId);
			LOGGER.info("Fetched Record", course);
		} catch (Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return course;
	}
}
