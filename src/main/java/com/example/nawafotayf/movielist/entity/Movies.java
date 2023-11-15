package com.example.nawafotayf.movielist.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_movies")
@JsonPropertyOrder({"id", "image", "name", "story", "duration", "studios","seasons","aired","users"})
public class Movies extends Shows{
    private LocalDate aired;

    public Movies(int id, String name, String story, double duration, String studios, int seasons,String image, Users users, LocalDate aired) {
        super(id, name, story, duration, studios, seasons, image, users);
        this.aired = aired;
    }
    public Movies(){

    }

    public LocalDate getAired() {
        return aired;
    }

    public void setAired(LocalDate aired) {
        this.aired = aired;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "aired=" + aired +
                '}';
    }
}
