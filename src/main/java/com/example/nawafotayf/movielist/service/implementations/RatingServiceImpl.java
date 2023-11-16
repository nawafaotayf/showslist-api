package com.example.nawafotayf.movielist.service.implementations;

import com.example.nawafotayf.movielist.entity.Rating;
import com.example.nawafotayf.movielist.repository.RatingRepository;
import com.example.nawafotayf.movielist.service.interfaces.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public void addRating(List<Rating> ratings) {
        ratingRepository.saveAll(ratings);
    }

    @Override
    public List<Rating> listAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public void deleteRating(int id) {
       Rating rating = ratingRepository.findById(id).get();
       ratingRepository.delete(rating);
    }

    @Override
    public void updateRating(int id, Rating rating) {
        Rating findRating = ratingRepository.findById(id).get();
        if(rating.getRate() != null){
            findRating.setRate(rating.getRate());
        }
        if(rating.getComment() != null){
            findRating.setComment(rating.getComment());
        }
        ratingRepository.save(findRating);
    }

    @Override
    public Rating findRatingByShowsId(int id) {
        return ratingRepository.findByshows_id(id);

    }
}
