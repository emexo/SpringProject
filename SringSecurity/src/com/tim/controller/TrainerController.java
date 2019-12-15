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

import com.tim.dao.StudentDao;
import com.tim.domain.Student;
import com.tim.domain.Trainer;
import com.tim.service.TimService;
@RestController
@RequestMapping("/trainer")
public class TrainerController {
	@Autowired
	private TimService timService;
	private static final Logger LOGGER = LogManager.getLogger(TrainerController.class.getName());
	
	// http://localhost:8080/trainer/save
//	{
//		"trainerName":"Alex", 
//			 "experience": "9 years",
//			 "skillset":"AWS",
//			 "availability":"Weekend"
//		}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveTrainer(@RequestBody Trainer trainer) {
		try {
		timService.insertTrainer(trainer);
		LOGGER.info("Records inserted successfully");
		}catch(Exception e) {
			LOGGER.error("Cannot insert records", e);
		}
		return "Record inserted successfully";
	}
	// http://localhost:8080/trainer/delete/2
	@RequestMapping(value="/delete/{trainerId}",method=RequestMethod.DELETE)
	public String deleteTrainer(@PathVariable("trainerId") int trainerId) {
		int result=0;
		try {
		timService.deleteTrainer(trainerId);
		LOGGER.info("Record Deleted Successfully", result);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return "Record Deleted Successfully";
	}
	// http://localhost:8080/trainer/update
	
//	{
//		"trainerId":2,
//	"trainerName":"Smith", 
//		 "availability":"Weekend"
//	}
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public String updateTrainer(@RequestBody Trainer trainer) {
		int result=0;
		try {
			result=timService.updateTrainer(trainer);
			LOGGER.info("Record Updated Successfully", result);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return "Records Updated Successfully";
	}
	// http://localhost:8080/trainer/getAll
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Trainer> getAllTrainers(){
		List<Trainer> trainerList=new ArrayList<Trainer>();
		try {
			trainerList=timService.getAllTrainers();
			LOGGER.info("Fetched Records", trainerList);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return trainerList;
	}
	// http://localhost:8080/trainer/getById?trainerId=2
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	public Trainer getTrainerById(@RequestParam("trainerId")int trainerId) {
		Trainer trainer=new Trainer();
		try {
			trainer=timService.getTrainerById(trainerId);
			LOGGER.info("Fetched Records", trainer);
		}catch(Exception e) {
			LOGGER.error("No Records Found", e);
		}
		return trainer;
	}

}
