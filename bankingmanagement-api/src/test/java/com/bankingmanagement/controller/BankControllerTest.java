package com.bankingmanagement.controller;

import com.bankingmanagement.exception.BankDetailsNotFound;
import com.bankingmanagement.model.BankDTO;
import com.bankingmanagement.model.BranchDTO;
import com.bankingmanagement.service.BankService;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BankControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BankService bankService;

    @Test
    public void testGetBanks() throws Exception {
        List<BankDTO> bankDTOList = new ArrayList<>();
        BankDTO bankDTO = new BankDTO();
        bankDTO.setBankName("SBI");
        bankDTO.setBankAddress("Bangalore");
        List<BranchDTO> branchDTOList = new ArrayList<>();
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchName("Electronic City");
        branchDTO.setBranchAddress("Electronic City");
        branchDTOList.add(branchDTO);
        bankDTO.setBranchDTOList(branchDTOList);
        bankDTOList.add(bankDTO);

        when(bankService.findAll()).thenReturn(bankDTOList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/banks")
                .contentType(MediaType.APPLICATION_JSON);

/*        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());*/

        // compare the body
        mockMvc.perform(requestBuilder).andExpect(jsonPath("$", Matchers.hasSize(1))).andDo(print());

        // compare the status code
        mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }
    @Test
    public void testGetBanksWithException() throws Exception {

        when(bankService.findAll()).thenThrow(new NullPointerException());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/banks")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isInternalServerError());

    }

    @Test
    public void testGetBanksWithEmptyData() throws Exception {
        List<BankDTO> bankDTOList = new ArrayList<>();

        when(bankService.findAll()).thenReturn(bankDTOList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/banks")
                .contentType(MediaType.APPLICATION_JSON);

        // compare the status code
        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());

    }

    @Test
    public void testGetBankByCode() throws Exception {
        BankDTO bankDTO = new BankDTO();
        bankDTO.setBankName("SBI");
        bankDTO.setBankAddress("Bangalore");
        List<BranchDTO> branchDTOList = new ArrayList<>();
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchName("Electronic City");
        branchDTO.setBranchAddress("Electronic City");
        branchDTOList.add(branchDTO);
        bankDTO.setBranchDTOList(branchDTOList);

        when(bankService.findBankDetails(anyInt())).thenReturn(bankDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/banks/99")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void testSave() throws Exception {
        BankDTO bankDTO = new BankDTO();
        bankDTO.setBankName("SBI");
        bankDTO.setBankAddress("Bangalore");
        List<BranchDTO> branchDTOList = new ArrayList<>();
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchName("Electronic City");
        branchDTO.setBranchAddress("Electronic City");
        branchDTOList.add(branchDTO);
        bankDTO.setBranchDTOList(branchDTOList);

        when(bankService.save(any())).thenReturn(bankDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/banks")
                .content(asJsonString(bankDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }

    @Test
    public void testUpdate() throws Exception {
        BankDTO bankDTO = new BankDTO();
        bankDTO.setBankName("SBI");
        bankDTO.setBankAddress("Bangalore");
        List<BranchDTO> branchDTOList = new ArrayList<>();
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchName("Electronic City");
        branchDTO.setBranchAddress("Electronic City");
        branchDTOList.add(branchDTO);
        bankDTO.setBranchDTOList(branchDTOList);

        when(bankService.save(any())).thenReturn(bankDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/banks")
                .content(asJsonString(bankDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }

    @Test
    public void testDelete() throws Exception {
        when(bankService.delete(anyInt())).thenReturn("Bank has been deleted");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/banks?code=99")
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
