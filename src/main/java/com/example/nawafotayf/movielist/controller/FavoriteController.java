package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.entity.Favorite;
import com.example.nawafotayf.movielist.service.implementations.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteController {
    @Autowired
    private FavoriteServiceImpl favoriteServiceImpl;
    @PostMapping(value = "/movielist/favorite")
    public ResponseEntity<String> addShowsToFavorite(@RequestBody Favorite favorite){
        try {
            favoriteServiceImpl.addShowsToFavorite(favorite);
            String message = "shows in your favorite add successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }
        catch (Exception e){
            String message = "its added already\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @GetMapping(value = "/movielist/favorite/{id}")
    public List<Favorite> getAllFavoriteByUserId(@PathVariable int id){
        return favoriteServiceImpl.getAllFavoriteByUserId(id);
    }
}
