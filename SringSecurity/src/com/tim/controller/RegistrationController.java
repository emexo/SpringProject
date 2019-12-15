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
import org.springframework.web.client.RestTemplate;

import com.tim.dao.StudentDao;
import com.tim.domain.Course;
import com.tim.domain.Registration;
import com.tim.service.TimService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
	private TimService timService;
	private static final Logger LOGGER = LogManager.getLogger(CourseController.class.getName());
	// http://localhost:8080/registration/save

	
	
	/*
	 * { "studentId":"1", "courseId":"1", "trainerId":"3",
	 * "courseStartDate":"2019-11-01", "courseEndDate":"2019-12-15",
	 * "weekdaysWeekend":"Weekend", "batchTime":"11 AM", "status":"Not Yet Started",
	 * "courseFee":8000.0 }
	 */
	 
	 
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRegistration(@RequestBody Registration registration) {
		try {
			timService.insertRegistration(registration);
			LOGGER.info("Record inserted successfully");
		} catch (Exception e) {
			LOGGER.error("Cannot insert record", e);
		}
		return "Records Inserted Successfully";
	}

	// http://localhost:8080/registration/delete/1
	@RequestMapping(value = "/delete/{registrationId}", method = RequestMethod.DELETE)
	public String deleteRegistration(@PathVariable("registrationId") int registrationId) {
		int result = 0;
		try {
			result = timService.deleteRegistration(registrationId);
			LOGGER.info("Record deleted successfully", result);
		} catch (Exception e) {
			LOGGER.error("No Record Found", e);
		}
		return "Record Deleted Successfully";
	}

	// http://localhost:8080/registration/update
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateRegistration(@RequestBody Registration registration) {
		int result = 0;
		try {
			result = timService.updateRegistration(registration);
			LOGGER.info("Recprds updated successfully", result);
		} catch (Exception e) {
			LOGGER.error("Record not updated", e);
		}
		return "Records updated successfully";
	}

	// http://localhost:8080/registration/getAll
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Registration> getAllRegistration() {
		List<Registration> regList = new ArrayList<Registration>();
		try {
			regList = timService.getAllRegistration();
			LOGGER.info("Fetched Records", regList);
		} catch (Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return regList;
	}

	// http://localhost:8080/registration/getById?registrationId=1
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public Registration getRegistrationById(@RequestParam("registrationId") int registrationId) {
		Registration registration = new Registration();
		try {
			registration = timService.getRegistrationById(registrationId);
			
			LOGGER.info("Fetched record", registration);
		} catch (Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return registration;
	}
}
