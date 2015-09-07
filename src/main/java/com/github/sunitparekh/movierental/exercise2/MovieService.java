package com.github.sunitparekh.movierental.exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class MovieService {

    @Autowired
    RestTemplate rest;

    public Movie fetchMovie(String imdbId){
        String url = String.format("http://www.omdbapi.com/?i=%s&plot=full&r=json",imdbId);
        Map movieMap = rest.getForObject(url,Map.class);
        return Movie.create(movieMap);
    }

}
