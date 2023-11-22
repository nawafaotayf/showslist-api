package com.example.nawafotayf.movielist.service.implementations;

import com.example.nawafotayf.movielist.entity.Favorite;
import com.example.nawafotayf.movielist.repository.FavoriteRepository;
import com.example.nawafotayf.movielist.service.interfaces.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
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
//        Double average = favoriteRepository.findAverageRatingByShowId(id);
//        DecimalFormat df = new DecimalFormat("#.##");
//        return Double.parseDouble(df.format(average));
        Double average = favoriteRepository.findAverageRatingByShowId(id);

        // Use Locale.getDefault() to get the default locale of the system
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());

        // Set the maximum fraction digits to 2
        nf.setMaximumFractionDigits(2);

        try {
            // Parse the formatted number using the NumberFormat instance
            return nf.parse(nf.format(average)).doubleValue();
        } catch (ParseException e) {
            // Handle the exception appropriately
            e.printStackTrace();
            return null; // or throw an exception or return a default value
        }
    }

    @Override
    public String deleteFavoriteById(int id) {
        Favorite favoriteId = favoriteRepository.findById(id).get();
        favoriteRepository.delete(favoriteId);
        return "deleted";
    }

    @Override
    public Optional<Favorite> getfavoriteByShowIdAndUserId(int userId, int showId) {
        return favoriteRepository.findByUsersIdAndShowsId(userId, showId);
    }


}
