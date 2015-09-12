package com.github.sunitparekh.movierental.exercise2;

import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Service("fileMovieService")
public class FileMovieService implements MovieService {

    @Autowired
    ApplicationContext context;

    public Movie fetchMovie(String imdbId) throws IOException {
        String filePath = String.format("classpath:movies/%s.json",imdbId);
        Resource resource = context.getResource(filePath);
        Map movieMap = JsonPath.read(resource.getFile(),"$");
        return Movie.create(movieMap);
    }

}
