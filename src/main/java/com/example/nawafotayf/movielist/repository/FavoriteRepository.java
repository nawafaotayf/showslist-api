package com.example.nawafotayf.movielist.repository;

import com.example.nawafotayf.movielist.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findAllByusers_id(int id);
    Optional<Favorite> findByUsersIdAndShowsId(int userId, int showsId);
}
