package com.github.sunitparekh.movierental.exercise2;

import com.github.sunitparekh.movierental.ApplicationConfigurations;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfigurations.class)
public class OmdbMovieServiceTest {

    @Autowired
    @Qualifier("omdbMovieService")
    public MovieService movieService;

    @Autowired
    public RestTemplate restTemplate;

    @Ignore
    @Test
    public void testMovieServiceWithoutMock() throws IOException {
        Movie movie = movieService.fetchMovie("tt2381249");
        assertThat(movie.Title,equalTo("Mission: Impossible - Rogue Nation"));
    }

    @Test
    public void testMovieServiceWithMock() throws IOException {
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(requestTo("http://www.omdbapi.com/?i=tt2381249&plot=full&r=json"))
                .andRespond(withSuccess("{ \"Title\" : \"Sunit Parekh\" }", MediaType.APPLICATION_JSON));

        Movie movie = movieService.fetchMovie("tt2381249");

        mockServer.verify();
        assertThat(movie.Title,equalTo("Sunit Parekh"));
    }

    @Test(expected = HttpServerErrorException.class)
    public void testMovieServiceWhenServiceThrowsServerError() throws IOException {
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(requestTo("http://www.omdbapi.com/?i=tt2381249&plot=full&r=json"))
                .andRespond(withServerError());

        try {
            movieService.fetchMovie("tt2381249");
        } catch (HttpServerErrorException e) {
            mockServer.verify();
            throw e;
        }

    }
}