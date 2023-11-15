package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.entity.Movies;

import java.util.List;

public interface MoviesService {
    public void addmovie(List<Movies> movies);
    public List<Movies> listAllMovies();
    public void deleteMovie(String name);
    public void updateMovie(String name, Movies movies);
    public Movies findMovieByName(String name);
}
