package com.example.babysitterKata;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BabysitterKataControllerTest {

    MockMvc mvc;

    @Mock
    BabysitterKataService babysitterKataService;

    @InjectMocks
    BabysitterKataController babysitterKataController;


    @Before
    public void setUp(){

    }

    @Test
    public void validateStartTimeEndpointReturnsAHappyString() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(babysitterKataController).build();
        when(babysitterKataService.validateStartTimeWithInRange(anyInt())).thenReturn(true);
        mvc.perform(post("/startTime"))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Start Time Entered."));


    }

}