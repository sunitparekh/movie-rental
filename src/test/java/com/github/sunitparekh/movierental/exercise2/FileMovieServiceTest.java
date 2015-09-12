package com.github.sunitparekh.movierental.exercise2;

import com.github.sunitparekh.movierental.ApplicationConfigurations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfigurations.class)
public class FileMovieServiceTest {

    @Autowired
    @Qualifier("fileMovieService")
    MovieService movieService;

    @Test
    public void testMovieServiceWithoutMock() throws IOException {
        Movie movie = movieService.fetchMovie("tt2381249");
        assertThat(movie.getTitle(),equalTo("Mission: Impossible - Rogue Nation"));
    }

}