package com.example.nawafotayf.movielist.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_shows")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonPropertyOrder({"id", "image", "name", "story", "duration", "studios","seasons","users"})
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(unique = true)
    private String name;
    private String story;
    private String duration;
    private String studios;
    private int seasons;
    private String image;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @OneToMany(mappedBy = "shows" ,cascade = CascadeType.ALL)
    private Set<Rating> rating;
    @OneToMany(mappedBy = "shows" ,cascade = CascadeType.ALL)
    private Set<Favorite> favorite;

    public Shows(int id, String name, String story, String duration, String studios, int seasons,String image, Users users) {
        Id = id;
        this.name = name;
        this.story = story;
        this.duration = duration;
        this.studios = studios;
        this.seasons = seasons;
        this.image = image;
        this.users = users;
    }
    public Shows(){

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Shows{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", story='" + story + '\'' +
                ", duration=" + duration +
                ", studios='" + studios + '\'' +
                ", seasons=" + seasons +
                ", users=" + users +
                '}';
    }


}
