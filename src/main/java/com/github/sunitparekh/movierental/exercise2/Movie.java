package com.github.sunitparekh.movierental.exercise2;

import java.util.Map;

public class Movie {
    public String Title;

    public static Movie create(Map movieMap) {
        Movie movie = new Movie();
        movie.Title = (String) movieMap.get("Title");
        return movie;
    }
}
