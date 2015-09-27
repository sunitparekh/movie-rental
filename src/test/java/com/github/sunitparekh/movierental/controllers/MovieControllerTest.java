package com.github.sunitparekh.movierental.controllers;

import com.github.sunitparekh.movierental.MovieRentalApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MovieRentalApplication.class)
@WebAppConfiguration

public class MovieControllerTest {
    protected MockMvc mockMVC;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        mockMVC = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldReturnStatus200() throws Exception {
        mockMVC.perform(get("/movies"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldHaveNameIntheResponseH1Tag() throws Exception {
        mockMVC.perform(get("/movies"))
                .andExpect(content().string(containsString("<div class=\"col-md-4\">3 Idiots</div>")));
    }

}