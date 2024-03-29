package com.bugtracking.controller;

import com.bugtracking.entity.Application;
import com.bugtracking.service.ApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApplicationService applicationService;


    @Test
    public void testGetAllApplications() throws Exception {

        List<Application> applicationList = new ArrayList<>();
        Application application = new Application();
        application.setId(1l);
        application.setName("LRI");
        application.setOwner("JPMC");
        application.setDescription("JPMC");
        applicationList.add(application);
        when(applicationService.listApplications()).thenReturn(applicationList);

        //Create a post request with an accept header for application\json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Assert that the return status is OK
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetAllApplications1() throws Exception {
        List<Application> applicationList = new ArrayList<>();
        Application application = new Application();
        application.setId(1l);
        application.setName("LRI");
        application.setOwner("JPMC");
        application.setDescription("JPMC");
        applicationList.add(application);
        when(applicationService.listApplications()).thenReturn(applicationList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(jsonPath("$", Matchers.hasSize(1))).andDo(print());

    }

    @Test
    public void testGetAllApplicationsWithException() throws Exception {

        when(applicationService.listApplications()).thenThrow(new NullPointerException());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Assert that the return status is OK
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
    }

    @Test
    public void getApplication() throws Exception {
        Application application = new Application();
        application.setId(1l);
        application.setName("LRI");
        application.setOwner("JPMC");
        application.setDescription("JPMC");
        when(applicationService.findApplication(anyLong())).thenReturn(application);

        //Create a post request with an accept header for application\json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/applications/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Assert that the return status is OK
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getApplication1() throws Exception {
        Application application = new Application();
        application.setId(1l);
        application.setName("LRI");
        application.setOwner("JPMC");
        application.setDescription("JPMC");
        when(applicationService.findApplication(anyLong())).thenReturn(application);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/applications/1")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.owner").value("JPMC"))
                .andExpect(jsonPath("$.description").value("JPMC"))
                .andDo(print());
    }


    @Test
    public void saveApplicationTest() throws Exception {
        Application application = new Application();
        application.setId(1l);
        application.setName("LRI");
        application.setOwner("JPMC");
        application.setDescription("JPMC");
        when(applicationService.save(any())).thenReturn(application);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/applications")
                .content(asJsonString(application))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }

    @Test
    public void saveApplicationTestWithException() throws Exception {
        when(applicationService.save(any())).thenThrow(new NullPointerException());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/applications")
                .content(asJsonString(new Application("LRI", "JPMC", "Liquidity Risk Management")))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());

    }

    @Test
    public void saveApplicationTestWithEmptyData() throws Exception {
        Application application = new Application();
        application.setId(1l);
        application.setName("LRI");
        application.setOwner("JPMC");
        application.setDescription("JPMC");
        when(applicationService.save(any())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/applications")
                .content(asJsonString(application))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isInternalServerError());

    }

    @Test
    public void updateApplicationTest() throws Exception {
        Application application = new Application();
        application.setId(1l);
        application.setName("LRI");
        application.setOwner("JPMC");
        application.setDescription("JPMC");
        when(applicationService.save(any())).thenReturn(application);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/applications")
                .content(asJsonString(application))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }

    @Test
    public void updateApplicationTestWithException() throws Exception {
        when(applicationService.save(any())).thenThrow(new NullPointerException());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/applications")
                .content(asJsonString(new Application(1,"LRI", "JPMC", "Liquidity Risk Management")))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());

    }

    @Test
    public void deleteApplication() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/applications?id=1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Assert that the return status is OK
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void deleteApplication1() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/applications?id=1")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());
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

}
