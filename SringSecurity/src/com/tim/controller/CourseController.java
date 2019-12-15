package com.tim.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tim.domain.Course;
import com.tim.service.TimService;


@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private TimService timService;
	
	private static final Logger LOGGER = LogManager.getLogger(CourseController.class.getName());
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/add")
	public ModelAndView addCourse(Model model) {
		//Employee employee=new Employee();
		
		model.addAttribute("course", new Course());
		return new ModelAndView("saveCourse");
	}

	// http://localhost:8080/course/save
	/*
	 * { "courseName": "Python", "duration": "2 Months", "fee": "10000",
	 * "courseDesc": "Python Core and Advance", "credits": "25%" }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course) {
		try {
			timService.insertCourse(course);
			LOGGER.info("Record Inserted Successfully");

		} catch (Exception e) {
			LOGGER.error("Error Inserting Records", e);
		}
		return "redirect:/course/getAll";
	}

//	http://localhost:8080/course/delete/1
	@RequestMapping(value = "/delete/{courseId}")
	public String deleteCourse(@PathVariable("courseId") int courseId) {
		int result = 0;
		try {
			result = timService.deleteCourse(courseId);
			LOGGER.info("Record Deleted Successfully", result);
		} catch (Exception e) {
			LOGGER.error("No Record found", e);
		}
		return "redirect:/course/getAll";
	}
	// http://localhost:8080/course/update
	// { "courseId:"2","courseName": "Python", "duration": "2 Months" }
	
	@RequestMapping("/editDetails/{courseId}")
	public String updateCourse(@PathVariable("courseId") int courseId,Model m) {
		
		Course course=timService.getCourseById(courseId);
		m.addAttribute("course", course);
		return "updateCourse";
	}
	@RequestMapping(value = "/update")
	public String updatesave(@ModelAttribute("course") Course course) {
		int result = 0;
		try {
			result = timService.updateCourse(course);
			LOGGER.info("Records Updated Successfully", result);
		} catch (Exception e) {
			LOGGER.error("Record Not Updated", e);
		}
		return "redirect:/course/getAll";

	}

	// http://localhost:8080/course/getAll
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ModelAndView getAllCourse(Model m) {
		List<Course> courseList = new ArrayList<Course>();
		try {
			courseList = timService.getAllCourse();
			m.addAttribute("list",courseList);
			LOGGER.info("Fetched Records", courseList);
		} catch (Exception e) {
			LOGGER.error("No Records Found", e);
		}
		
		return new ModelAndView("courseDetails");
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
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Course> result = timService.searchCourse(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("list", result);
		
		return mav;		
	}	
}
