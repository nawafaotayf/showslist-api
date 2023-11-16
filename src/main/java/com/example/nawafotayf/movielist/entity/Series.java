package com.example.nawafotayf.movielist.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_series")
@JsonPropertyOrder({"id", "image", "name", "story", "duration", "studios","seasons","episodes","start","end","users"})
@CrossOrigin
public class Series extends Shows{
    private int episodes;
    private LocalDate start;
    private LocalDate end;

    public Series(int id, String name, String story, double duration, String studios, int seasons, String image, Users users, int episodes, LocalDate start, LocalDate end) {
        super(id, name, story, duration, studios, seasons, image, users);
        this.episodes = episodes;
        this.start = start;
        this.end = end;
    }
    public Series(){

    }
    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Series series = (Series) o;
        return episodes == series.episodes && Objects.equals(start, series.start) && Objects.equals(end, series.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), episodes, start, end);
    }

    @Override
    public String toString() {
        return "Series{" +
                "episodes=" + episodes +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
