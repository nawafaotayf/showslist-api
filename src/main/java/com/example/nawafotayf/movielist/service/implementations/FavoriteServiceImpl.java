package com.example.nawafotayf.movielist.service.implementations;

import com.example.nawafotayf.movielist.entity.Favorite;
import com.example.nawafotayf.movielist.repository.FavoriteRepository;
import com.example.nawafotayf.movielist.service.interfaces.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    FavoriteRepository favoriteRepository;
    @Override
    public List<Favorite> getAllFavoriteByUserId(int id) {
        return favoriteRepository.findAllByusers_id(id);
    }

    @Override
    public String addShowsToFavorite(Favorite favorite) {
        Optional<Favorite> isFound = favoriteRepository.findByUsersIdAndShowsId(
            favorite.getUsers().getId(),
            favorite.getShows().getId()
        );
        if(isFound.isPresent()) {
            isFound.get();

            return "its added already";
    }
        favoriteRepository.save(favorite);
        return "added";
    }

    @Override
    public Double findAverageRatingByShowId(int id) {
        return favoriteRepository.findAverageRatingByShowId(id);
    }

    @Override
    public String deleteFavoriteById(int id) {
        Favorite favoriteId = favoriteRepository.findById(id).get();
        favoriteRepository.delete(favoriteId);
        return "deleted";
    }


}
