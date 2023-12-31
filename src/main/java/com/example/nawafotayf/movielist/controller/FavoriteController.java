package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.entity.Favorite;
import com.example.nawafotayf.movielist.service.implementations.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FavoriteController {
    @Autowired
    private FavoriteServiceImpl favoriteServiceImpl;
    @PostMapping(value = "/movielist/favorite")
    public String addShowsToFavorite(@RequestBody Favorite favorite){
        return favoriteServiceImpl.addShowsToFavorite(favorite);
    }
    @GetMapping(value = "/movielist/favorite/user/{id}")
    public List<Favorite> getAllFavoriteByUserId(@PathVariable int id){
        return favoriteServiceImpl.getAllFavoriteByUserId(id);
    }
    @GetMapping(value = "/movielist/favorite/show/{userId}/{showId}")
    public Optional<Favorite> getFavoriteByUserIdAndShowId(@PathVariable int userId, @PathVariable int showId){
        return favoriteServiceImpl.getfavoriteByShowIdAndUserId(userId, showId);
    }
    @GetMapping(value = "/movielist/favorite/avg-rating/{id}")
    public Double getAverageRatingByShowId(@PathVariable int id){
        return favoriteServiceImpl.findAverageRatingByShowId(id);
    }
    @DeleteMapping(value = "/movielist/favorite/delete/{id}")
    public String deleteFavoriteById(@PathVariable int id){
        return favoriteServiceImpl.deleteFavoriteById(id);
    }

}
