package com.example.nawafotayf.movielist.service.implementations;

import com.example.nawafotayf.movielist.entity.Movies;
import com.example.nawafotayf.movielist.repository.MoviesRepository;
import com.example.nawafotayf.movielist.service.interfaces.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    MoviesRepository moviesRepository;
    @Override
    public void addmovie(List<Movies> movies) {
        moviesRepository.saveAll(movies);
    }

    @Override
    public List<Movies> listAllMovies() {
        return moviesRepository.findAll();
    }
    @Override
    public void deleteMovie(int id) {
        Movies movieName = moviesRepository.findById(id).get();
        moviesRepository.delete(movieName);
    }
    @Override
    public void updateMovie(String name, Movies movies) {
        Movies movieName = moviesRepository.findByname(name);
        if(movies.getName() != null){
            movieName.setName(movies.getName() );
        }
        if(movies.getStory() != null){
            movieName.setStory(movies.getStory());
        }
        if(movies.getDuration() != 0){
            movieName.setDuration(movies.getDuration());
        }
        if(movies.getStudios() != null){
            movieName.setStudios(movies.getStudios());
        }
        if(movies.getImage() != null){
            movieName.setImage(movies.getImage());
        }

        moviesRepository.save(movieName);
    }

    @Override
    public Movies findMovieByName(String name) {
        Movies movieName = moviesRepository.findByname(name);
        return movieName;
    }

    @Override
    public Movies findMovieById(int id) {
        Movies movieId = moviesRepository.findById(id).get();
        return movieId;
    }

    @Override
    public void updateMovieById(int id, Movies movies) {
        Movies movieId = moviesRepository.findById(id).get();
        if(movies.getName() != null){
            movieId.setName(movies.getName() );
        }
        if(movies.getStory() != null){
            movieId.setStory(movies.getStory());
        }
        if(movies.getDuration() != 0){
            movieId.setDuration(movies.getDuration());
        }
        if(movies.getStudios() != null){
            movieId.setStudios(movies.getStudios());
        }
        if(movies.getImage() != null){
            movieId.setImage(movies.getImage());
        }

        moviesRepository.save(movieId);
    }

}



