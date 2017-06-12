package ru.itis.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 08.05.2017
 * Film @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "releasedate")
    private String releaseDate;


    @Column
    private String country;

    @Column
    private String producer;

    @Column
    private int lasting;

    @Column
    private String description;

    @Column
    private String picture;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_genre",
            joinColumns =
            @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> genres = new HashSet<Genre>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",
            joinColumns =
            @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    private Set<Actor> actors = new HashSet<Actor>();

    public Film() {
    }

    public Film(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.releaseDate = builder.releaseDate;
        this.genres = builder.genre;
        this.country = builder.country;
        this.producer = builder.producer;
        this.lasting = builder.lasting;
        this.description = builder.description;
        this.actors = builder.actors;
        this.picture = builder.picture;
    }

    public static class Builder{
        private int id;
        private String name;
        private String releaseDate;
        private Set<Genre> genre = new HashSet<Genre>();
        private String country;
        private String producer;
        private int lasting;
        private String description;
        private Set<Actor> actors = new HashSet<Actor>();
        private String picture;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder releaseDate(String releaseDate){
            this.releaseDate = releaseDate;
            return this;
        }
        public Builder genre(Set<Genre> genre){
            this.genre = genre;
            return this;
        }
        public Builder country(String country){
            this.country = country;
            return this;
        }
        public Builder producer(String producer){
            this.producer = producer;
            return this;
        }
        public Builder lasting(int lasting){
            this.lasting = lasting;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder actors(Set<Actor> actors){
            this.actors = actors;
            return this;
        }
        public Builder picture(String picture){
            this.picture = picture;
            return this;
        }
        public Film build(){
            return new Film(this);
        }
    }


    public Set<Actor> getActors() {
        return actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setLasting(int lasting) {
        this.lasting = lasting;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public String getProducer() {
        return producer;
    }

    public int getLasting() {
        return lasting;
    }

    public String getDescription() {
        return description;
    }


    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return  id +
                " " + name +
                " " + releaseDate +
                " " + genres +
                " " + country +
                " " + producer +
                " " + lasting +
                " " + description +
                " " + actors +
                " " + picture;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null || obj instanceof Film){
            if(obj == this) return true;
            Film that = (Film) obj;
            return this.id == that.id
                    && this.name.equals(that.name)
                    && this.genres.equals(that.genres)
                    && this.actors.equals(that.actors)
                    && this.country.equals(that.country)
                    && this.description.equals(that.description)
                    && this.lasting == that.lasting
                    && this.producer.equals(that.producer)
                    && this.releaseDate.equals(that.releaseDate);
        }return false;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + lasting;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }
}