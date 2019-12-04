package com.tim.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
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
import com.tim.domain.Registration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrainingInstituteManagement.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	//@Test
	public void getAllRegistrationsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/registration/getAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", Matchers.hasSize(2))).andDo(print());
	}

	@Test
	public void getRegistrationByIdTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/registration/getById?registrationId=2").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("registrationId").exists()).andExpect(jsonPath("$.studentId").exists())
				.andExpect(jsonPath("$.courseId").exists()).andExpect(jsonPath("$.trainerId").exists())
				.andExpect(jsonPath("$.courseStartDate").exists()).andExpect(jsonPath("$.courseEndDate").exists())
				.andExpect(jsonPath("$.weekdaysWeekend").exists()).andExpect(jsonPath("$.batchTime").exists())
				.andExpect(jsonPath("$.status").exists()).andExpect(jsonPath("$.courseFee").exists())
				.andExpect(jsonPath("$.date").exists()).andDo(print());
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
	  public void saveRegistrationTest() throws Exception{ 
		Date date=new Date();
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		Date toDate=cal.getTime();
		Registration register=new Registration();
		register.setStudentId(1);
		register.setCourseId(2);
		register.setTrainerId(3);
		register.setCourseFee(9000);
		register.setCourseStartDate(date);
		register.setCourseEndDate(toDate);
		register.setDate(new Date());
		register.setStatus("New");
		register.setWeekdaysWeekend("Weekend");
		register.setBatchTime("10 AM");
		  mockMvc.perform(
	  MockMvcRequestBuilders .post("/registration/save") .
	  content(asJsonString(register))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
	  .andExpect(status().isOk());
	  }
	
	//@Test
	public void deleteRegistrationByIdTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/registration/delete/5").accept(MediaType.APPLICATION_JSON))
      //  .andExpect(jsonPath("$.status").value(200))
      //  .andExpect(jsonPath("$.message").value("Course has been deleted"))
        .andDo(print());
	}
	@Test 
	  public void updateRegistrationTest() throws Exception{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		Date toDate=cal.getTime();
		Registration register=new Registration();
		register.setRegistrationId(9);
		register.setCourseStartDate(new Date());
		register.setCourseEndDate(toDate);
		  mockMvc.perform(
	  MockMvcRequestBuilders .put("/registration/update") .
	  content(asJsonString(register))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
	  .andExpect(status().isOk()).andDo(print());
	  
	  }
}
