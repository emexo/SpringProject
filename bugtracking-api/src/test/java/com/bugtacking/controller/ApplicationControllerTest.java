package com.bugtacking.controller;

import com.bugtacking.exception.ApplicationNotFoundException;
import com.bugtacking.model.ApplicationVO;
import com.bugtacking.service.ApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ApplicationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ApplicationService applicationService;

    @Test
    public void testGetApplications() throws Exception {
        List<ApplicationVO> applicationVOS = new ArrayList<>();
        ApplicationVO  applicationVO = new ApplicationVO();
        applicationVO.setApplicationId(1);
        applicationVO.setApplicationName("LRI");
        applicationVO.setOwner("JPMC");
        applicationVO.setDescription("Liquidity Risk Management");
        applicationVOS.add(applicationVO);

        when (applicationService.findAll()).thenReturn(applicationVOS);

        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response= mvcResult.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetApplications1() throws Exception {
        List<ApplicationVO> applicationVOS = new ArrayList<>();
        ApplicationVO  applicationVO = new ApplicationVO();
        applicationVO.setApplicationId(1);
        applicationVO.setApplicationName("LRI");
        applicationVO.setOwner("JPMC");
        applicationVO.setDescription("Liquidity Risk Management");
        applicationVOS.add(applicationVO);

        when (applicationService.findAll()).thenReturn(applicationVOS);

        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON);

         mockMvc.perform(requestBuilder).andExpect(jsonPath("$", Matchers.hasSize(1))).andDo(print());
    }

    @Test
    public void testSaveApplication() throws Exception {
        ApplicationVO applicationVO =new ApplicationVO();
        applicationVO.setApplicationId(1);
        applicationVO.setApplicationName("LRI");
        applicationVO.setDescription("LRI");
        applicationVO.setOwner("JPMC");

        when(applicationService.save(any())).thenReturn(applicationVO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/applications")
                .content(asJsonString(applicationVO))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }

    @Test
    public void testSaveApplicationWithException() throws Exception {
        ApplicationVO applicationVO =new ApplicationVO();
        applicationVO.setApplicationId(1);
        applicationVO.setApplicationName("LRI");
        applicationVO.setDescription("LRI");
        applicationVO.setOwner("JPMC");

        when(applicationService.save(any())).thenThrow(new NullPointerException());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/applications")
                .content(asJsonString(applicationVO))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isInternalServerError());

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
