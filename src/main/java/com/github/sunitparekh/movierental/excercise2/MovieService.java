package com.github.sunitparekh.movierental.excercise2;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class MovieService {

    public Movie fetchMovie(String imdbId){
        String url = String.format("http://www.omdbapi.com/?i=%s&plot=full&r=json",imdbId);
        Map movieMap = new RestTemplate().getForObject(url,Map.class);
        Movie movie = new Movie();
        movie.setTitle((String) movieMap.get("Title"));
        return movie;
    }

}
