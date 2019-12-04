package com.tim.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tim.TrainingInstituteManagement;
import com.tim.domain.Course;
import com.tim.domain.Student;
import com.tim.domain.Trainer;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrainingInstituteManagement.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainerControllerTest {
private MockMvc mockMvc;
	
	@Autowired 
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	//@Test
	public void getAllTrainersTest()throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/trainer/getAll").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", Matchers.hasSize(2))).andDo(print());
	}
	
	@Test
	public void getTrainerByIdTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/trainer/getById?trainerId=1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("trainerId").exists())
		.andExpect(jsonPath("$.trainerName").exists())
		.andExpect(jsonPath("$.experience").exists())
		.andExpect(jsonPath("$.skillset").exists())
		.andExpect(jsonPath("$.availability").exists())
		.andExpect(jsonPath("$.availability").value("Weekday"))
		.andExpect(jsonPath("$.date").exists())
		.andExpect(jsonPath("$.date").value("2019-10-03"))
		.andDo(print());
	}
	public  String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
        @Test
        public void saveTrainerTest() throws Exception{ 
    		Trainer trainer=new Trainer();
    		trainer.setAvailability("Weekend");
    		trainer.setDate(new Date());
    		trainer.setExperience("10 years");
    		trainer.setSkillset("Java, Spring");
    		trainer.setTrainerName("Sundar");
    		  mockMvc.perform(
    	  MockMvcRequestBuilders .post("/trainer/save") .
    	  content(asJsonString(trainer))
    	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
    	  .andExpect(status().isOk());
    	  }
        @Test
    	public void deleteTrainerByIdTest() throws Exception{
    		mockMvc.perform(MockMvcRequestBuilders.delete("/trainer/delete/4").accept(MediaType.APPLICATION_JSON))
          //  .andExpect(jsonPath("$.status").value(200))
          //  .andExpect(jsonPath("$.message").value("Course has been deleted"))
            .andDo(print());
    	}
    	//@Test 
    	  public void updateTrainerTest() throws Exception{
    		Trainer trainer=new Trainer();
    		trainer.setAvailability("Weekday");
    		trainer.setTrainerId(1);
    		trainer.setTrainerName("Shobana");
    		  mockMvc.perform(
    	  MockMvcRequestBuilders .put("/trainer/update") .
    	  content(asJsonString(trainer))
    	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
    	  .andExpect(status().isOk()).andDo(print());
    	  
    	  }
}
