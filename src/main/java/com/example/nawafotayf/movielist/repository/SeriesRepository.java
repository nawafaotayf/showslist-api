package com.example.nawafotayf.movielist.repository;

import com.example.nawafotayf.movielist.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
    Series findByname(String name);
}
