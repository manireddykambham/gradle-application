package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class DemoControllerTest {
    private MockMvc mockMvc;
    @BeforeEach
    public void setup() {
        DemoController demoController = new DemoController();
        mockMvc=standaloneSetup(demoController).build();
    }

    @Test
    public void testHandlePostRequest() throws Exception {
        DemoController.CustomRequest customRequest = new DemoController.CustomRequest();
        customRequest.setData("test data");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(customRequest);

        // Perform the POST request and verify the response
        mockMvc.perform(post("/api/data")
                        .contentType("application/json")
                        .content(requestJson))
                .andExpect(status().isOk())  // Expect HTTP 200 OK
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Received your data: test data"));  // Verify the response message
    }
}
