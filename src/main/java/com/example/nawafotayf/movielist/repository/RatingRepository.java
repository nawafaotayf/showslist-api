package com.example.nawafotayf.movielist.repository;

import com.example.nawafotayf.movielist.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByshows_idOrderByIdDesc(int id);
}
