package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.entity.Movies;
import com.example.nawafotayf.movielist.service.implementations.MoviesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MovieController {
    @Autowired
    MoviesServiceImpl moviesServiceImpl;
    @GetMapping(value = "/movielist/movie/allmovies")
    public List<Movies> movies (){
        return moviesServiceImpl.listAllMovies();
    }

    @PostMapping(value = "/movielist-admin/movie/addmovies")
    public ResponseEntity<String> addMovie(@RequestBody List<Movies> movies){
        try {
            moviesServiceImpl.addmovie(movies);
            String message = "movie add successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }
        catch (Exception e){
            String message = "movie not added\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }

    @DeleteMapping(value = "/movielist-admin/movie/deletemovie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        try {
            moviesServiceImpl.deleteMovie(id);
            String message = "movie deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            String message = "movie not deleted\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @PutMapping(value = "/movielist-admin/movie/updatemoviebyname")
    public ResponseEntity<String> updatemovie(@RequestParam String name, @RequestBody Movies movies){
        try{
            moviesServiceImpl.updateMovie(name, movies);
            String message = "movie updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "movie not updated\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
        }
    @GetMapping(value = "/movielist/movie/findbyname")
    public Movies findbyname(@RequestParam String name){
        return moviesServiceImpl.findMovieByName(name);
    }
    @GetMapping(value = "/movielist/movie/{id}")
    public Movies findById(@PathVariable int id){
        return moviesServiceImpl.findMovieById(id);
    }

    @PutMapping(value = "/movielist-admin/movie/updatemovie/{id}")
    public ResponseEntity<String> updateMovieById(@PathVariable int id, @RequestBody Movies movies){
        try{
            moviesServiceImpl.updateMovieById(id, movies);
            String message = "movie updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "movie not updated\n   " + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }

}
