package com.github.sunitparekh.movierental.repositories;

import com.github.sunitparekh.movierental.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {

    List<Movie> findByReleaseYear(Integer releaseYear);


    @Query("SELECT m FROM Movie m WHERE m.releaseYear = :releaseYear")
    List<Movie> findByReleaseYear2(@Param("releaseYear") Integer releaseYear);
}
