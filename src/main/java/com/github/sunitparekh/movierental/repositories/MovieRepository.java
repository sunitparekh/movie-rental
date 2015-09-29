package com.github.sunitparekh.movierental.repositories;

import com.github.sunitparekh.movierental.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {

    List<Movie> findByReleaseYear(Integer releaseYear);
}
