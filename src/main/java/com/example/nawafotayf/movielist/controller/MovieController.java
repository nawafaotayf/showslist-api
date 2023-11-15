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

    @DeleteMapping(value = "/movielist-admin/movie/deletemovie")
    public ResponseEntity<String> deleteMovie(@RequestParam String name) {
        try {
            moviesServiceImpl.deleteMovie(name);
            String message = "movie deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            String message = "movie not deleted\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @PutMapping(value = "/movielist-admin/movie/updatemovie")
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


}
