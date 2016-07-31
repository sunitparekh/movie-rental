package com.github.sunitparekh.movierental.exercise2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileMovieServiceTest {

    @Autowired
    @Qualifier("fileMovieService")
    MovieService movieService;

    @Test
    public void testMovieServiceWithoutMock() throws IOException {
        Movie movie = movieService.fetchMovie("tt2381249");
        assertThat(movie.Title,equalTo("Mission: Impossible - Rogue Nation"));
    }

}