package com.github.sunitparekh.movierental.repositories;

import com.github.sunitparekh.movierental.models.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie,Integer> {
}
