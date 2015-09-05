package com.github.sunitparekh.movierental.excercise2;

import com.github.sunitparekh.movierental.ApplicationConfigurations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfigurations.class)
public class MovieServiceTest {

    @Autowired
    public MovieService movieService;

    @Test
    public void testMovie() throws Exception {
        Movie movie = movieService.fetchMovie("tt2381249");
        assertThat(movie.getTitle(),equalTo("Mission: Impossible - Rogue Nation"));
    }

}