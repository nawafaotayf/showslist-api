package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.entity.Favorite;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface FavoriteService {
    List<Favorite> getAllFavoriteByUserId(int id);
    String addShowsToFavorite(Favorite favorite);
    Double findAverageRatingByShowId(int id);
    String deleteFavoriteById(int id);
}
