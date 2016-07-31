package com.github.sunitparekh.movierental.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WelcomeControllerTest {
    protected MockMvc mockMVC;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        mockMVC = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldReturnStatus200() throws Exception {
        mockMVC.perform(get("/welcome/Sunit"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldHaveNameIntheResponseH1Tag() throws Exception {
        mockMVC.perform(get("/welcome/Sunit"))
                .andExpect(content().string(containsString("<h1>Hello, Sunit!</h1>")));
    }

}