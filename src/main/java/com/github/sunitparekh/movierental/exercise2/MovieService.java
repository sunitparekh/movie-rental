package com.github.sunitparekh.movierental.exercise2;

import java.io.IOException;

public interface MovieService {
    Movie fetchMovie(String imdbId) throws IOException;
}
