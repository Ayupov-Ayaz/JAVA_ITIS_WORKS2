package ru.itis.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 29.05.2017
 * Actor
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "actor_name")
    private String actorName;

    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new HashSet<>();

    public Actor(Builder builder){
        this.id = builder.id;
        this.actorName = builder.actorName;
        this.films = builder.film;
    }

    public Actor() {
    }


    public static class Builder{
        private int id;
        private String actorName;
        private Set<Film> film = new HashSet<>();

        public Builder film(Set<Film> film){
            this.film = film;
            return this;
        }

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder actorName(String actorName){
            this.actorName = actorName;
            return this;
        }
        public Actor build(){
            return new Actor(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public int hashCode() {
        return 31 * id + (actorName != null ? actorName.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Actor){
            if(obj == this) return true;

            Actor that = (Actor) obj;
            return this.id == that.id
                    && this.actorName.equals(that.actorName);
        }else
            return false;
    }

    @Override
    public String toString() {
        return  actorName + "\n";
    }
}
