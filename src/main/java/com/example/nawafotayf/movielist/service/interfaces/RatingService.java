package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.entity.Rating;

import java.util.List;

public interface RatingService {
    public void addRating(List<Rating> ratings);
    public List<Rating> listAllRating();
    public void deleteRating(int id);
    public void updateRating(int id, Rating rating);
}
