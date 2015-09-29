package com.github.sunitparekh.movierental.exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("omdbMovieService")
public class OmdbMovieService implements MovieService {

    @Autowired
    RestTemplate rest;

    @Override
    public Movie fetchMovie(String imdbId){
        String url = String.format("http://www.omdbapi.com/?i=%s&plot=full&r=json",imdbId);
        return rest.getForObject(url,Movie.class);
    }

}
