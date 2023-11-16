package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.entity.Movies;

import java.util.List;

public interface MoviesService {
    public void addmovie(List<Movies> movies);
    public List<Movies> listAllMovies();
    public void deleteMovie(int id);
    public void updateMovie(String name, Movies movies);
    public Movies findMovieByName(String name);
    public Movies findMovieById(int id);
    public void updateMovieById(int id, Movies movies);

}
