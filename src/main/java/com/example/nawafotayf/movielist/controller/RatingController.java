package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.entity.Rating;
import com.example.nawafotayf.movielist.service.implementations.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {
    @Autowired
    RatingServiceImpl ratingServiceImpl;

    @PostMapping(value = "/movielist/rating/addrating")
    public ResponseEntity<String> addRating(@RequestBody List<Rating> ratings){
        try{
            ratingServiceImpl.addRating(ratings);
            String message = "rating added successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "rating not added\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @GetMapping(value = "/movielist/rating/allrating")
    public List<Rating> ratings (){
        return ratingServiceImpl.listAllRating();
    }
    @DeleteMapping(value = "/movielist/rating/delete")
    public ResponseEntity<String> deleteRating(@RequestParam int id){
        try {
            ratingServiceImpl.deleteRating(id);
            String message = "rating deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "rating not deleted" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @PutMapping(value = "/movielist/rating/update")
    public ResponseEntity<String> updateRating(@RequestParam int id, @RequestBody Rating rating){
        try{
            ratingServiceImpl.updateRating(id, rating);
            String message = "rating added successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "rating not added" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
}
