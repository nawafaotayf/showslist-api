package com.example.nawafotayf.movielist.repository;

import com.example.nawafotayf.movielist.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    Movies findByname(String name);
}
