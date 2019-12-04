package com.tim.controller.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tim.TrainingInstituteManagement;
import com.tim.domain.Course;
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

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrainingInstituteManagement.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    //@Test
    public void getAllCoursesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/course/getAll")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(6))).andDo(print());
    }

    @Test
    public void getCourseByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/course/getById?courseId=2").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("courseId").exists())
                .andExpect(jsonPath("$.courseName").exists())
                .andExpect(jsonPath("$.duration").exists())
                .andExpect(jsonPath("$.fee").value(10000))
                .andExpect(jsonPath("$.courseDesc").value("Python Core and Advance"))
                .andExpect(jsonPath("$.credits").value("25%"))
                .andExpect(jsonPath("$.date").value("2019-10-02"))

                .andDo(print());
    }


    // @Test
    public void saveCourseTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/course/save")
                .content(asJsonString(new Course("Spring", "2 months", 8000, "Spring-ALL", "25%", new Date())))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    public String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deleteCourseByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/course/delete/4").accept(MediaType.APPLICATION_JSON))
                //  .andExpect(jsonPath("$.status").value(200))
                //  .andExpect(jsonPath("$.message").value("Course has been deleted"))
                .andDo(print());
    }

    @Test
    public void updateCourseTest() throws Exception {
        Course course = new Course();
        course.setCourseId(5);
        course.setCourseName("Java");
        course.setDuration("1 month");
        mockMvc.perform(
                MockMvcRequestBuilders.put("/course/update").
                        content(asJsonString(course))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());

    }

}
