package ru.itis.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 29.05.2017
 * Genre
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Set<Film> film = new HashSet<>();


    public Genre() {
    }

    public Genre(Builder builder){
        this.id = builder.id;
        this.genre = builder.genre;
        this.film = builder.film;
    }
    public static class Builder{
        private int id;
        private String genre;
        private Set<Film> film = new HashSet<>();

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder genre(String genre){
            this.genre = genre;
            return this;
        }
        public Builder film(Set<Film> film){
            this.film = film;
            return this;
        }
        public Genre build(){
            return new Genre(this);
        }

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Film> getFilm() {
        return film;
    }

    public void setFilm(Set<Film> film) {
        this.film = film;
    }

    @Override
    public int hashCode() {
        return 31 * id + (genre != null ? genre.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Genre){
            if(obj == this) return true;

            Genre that = (Genre)obj;
            return this.id == that.id
                    && this.genre.equals(that.genre);
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return genre +" ";
    }
}
