package com.example.babysitterKata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BabysitterKataControllerTest {

    MockMvc mvc;
    ObjectMapper mapper;

    @Mock
    BabysitterKataService babysitterKataService;

    @InjectMocks
    BabysitterKataController babysitterKataController;


    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(babysitterKataController).build();
        mapper = new ObjectMapper();
    }

    @Test
    public void validateJobEndpointReturnsAHappyString() throws Exception {
        String request = "[{\"payShiftStartTime\": 5, \"payShiftEndTime\": 10, \"payRate\": 5}]";
        when(babysitterKataService.validateStartTimeWithInRange(anyInt())).thenReturn(true);
        when(babysitterKataService.validateEndTimeWithInRange(anyInt(), anyInt())).thenReturn(true);
        when(babysitterKataService.calculatePay(any())).thenReturn(25);
        mvc.perform(post("/job").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(request))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Job Accepted"));
    }

    @Test
    public void validateJobEndpointInvalidStartTIme() throws Exception {
        String request = "[{\"payShiftStartTime\": 2, \"payShiftEndTime\": 10, \"payRate\": 5}]";
        when(babysitterKataService.validateStartTimeWithInRange(anyInt())).thenReturn(false);
        mvc.perform(post("/job")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(request))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validJobEndpointValidatesEndTIme() throws Exception {
        String request = "[{\"payShiftStartTime\": 5, \"payShiftEndTime\": 4, \"payRate\": 5}]";
        when(babysitterKataService.validateStartTimeWithInRange(anyInt())).thenReturn(true);
        when(babysitterKataService.validateEndTimeWithInRange(anyInt(), anyInt())).thenReturn(false);
        mvc.perform(post("/job")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(request))
                .andExpect(status().isBadRequest());
    }

}