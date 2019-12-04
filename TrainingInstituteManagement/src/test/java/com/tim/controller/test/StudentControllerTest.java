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
import com.tim.domain.Registration;
import com.tim.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrainingInstituteManagement.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentControllerTest{
	
	private MockMvc mockMvc;
	
	@Autowired 
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	//@Test
	public void getAllStudentsTest()throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/student/getAll").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andDo(print());
	}
	
	@Test
	public void getStudentByIdTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/student/getById?studentId=1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("studentId").exists())
		.andExpect(jsonPath("$.firstName").exists())
		.andExpect(jsonPath("$.lastName").exists())
		.andExpect(jsonPath("$.mobile").exists())
		.andExpect(jsonPath("$.emailId").exists())
		.andExpect(jsonPath("$.gender").exists())
	//	.andExpect(jsonPath("$.experience").exists())
		.andExpect(jsonPath("$.course").value("Spring"))
		.andExpect(jsonPath("$.availability").value("Weekday"))
		.andExpect(jsonPath("$.mode").value("classroom"))
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
	//@Test
	  public void saveStudentTest() throws Exception{ 
		Student student=new Student();
		student.setFirstName("Shobana");
		student.setLastName("Sundar");
		student.setAvailability("Weekend");
		student.setCourse("Java");
		student.setDate(new Date());
		student.setEmailId("shobivasu91@gmail.com");
		student.setExperience("5 years");
		student.setGender("F");
		student.setMobile("9988774455");
		student.setMode("Online");
		  mockMvc.perform(
	  MockMvcRequestBuilders .post("/student/save") .
	  content(asJsonString(student))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
	  .andExpect(status().isOk());
	  }
        @Test
    	public void deleteCourseByIdTest() throws Exception{
    		mockMvc.perform(MockMvcRequestBuilders.delete("/student/delete/3").accept(MediaType.APPLICATION_JSON))
          //  .andExpect(jsonPath("$.status").value(200))
          //  .andExpect(jsonPath("$.message").value("Course has been deleted"))
            .andDo(print());
    	}
    //	@Test 
    	  public void updateStudentTest() throws Exception{
    		Student student=new Student();
    		student.setStudentId(1);
    		student.setFirstName("Aathmik");
    		student.setLastName("Sundar");
    		  mockMvc.perform(
    	  MockMvcRequestBuilders .put("/student/update") .
    	  content(asJsonString(student))
    	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
    	  .andExpect(status().isOk()).andDo(print());
    	  
    	  }
}

