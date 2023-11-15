package com.example.nawafotayf.movielist.repository;

import com.example.nawafotayf.movielist.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
