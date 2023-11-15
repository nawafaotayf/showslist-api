package com.example.nawafotayf.movielist.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private RateEnum rate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Shows shows;

    public Rating(String comment, RateEnum rate) {
        this.comment = comment;
        this.rate = rate;
    }
    public Rating(){

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public RateEnum getRate() {
        return rate;
    }

    public void setRate(RateEnum rate) {
        this.rate = rate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return id == rating.id && Objects.equals(comment, rating.comment) && rate == rating.rate && Objects.equals(users, rating.users) && Objects.equals(shows, rating.shows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, rate, users, shows);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", rate=" + rate +
                ", users=" + users +
                ", shows=" + shows +
                '}';
    }
}
