package com.github.sunitparekh.movierental.exercise2;

import java.util.Map;

public class Movie {
    private String title;

    public String getTitle() {
        return title;
    }

    public static Movie create(Map movieMap) {
        Movie movie = new Movie();
        movie.title = (String) movieMap.get("Title");
        return movie;
    }
}
