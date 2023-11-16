package com.example.nawafotayf.movielist.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private RateEnum rating;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Shows shows;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public Favorite() {
    }

    public Favorite(int id, RateEnum rating, Shows shows, Users users) {
        this.id = id;
        this.rating = rating;
        this.shows = shows;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RateEnum getRating() {
        return rating;
    }

    public void setRating(RateEnum rating) {
        this.rating = rating;
    }

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return id == favorite.id && rating == favorite.rating && Objects.equals(shows, favorite.shows) && Objects.equals(users, favorite.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, shows, users);
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", rating=" + rating +
                ", shows=" + shows +
                ", users=" + users +
                '}';
    }
}

