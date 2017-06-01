package ru.itis.models;

/**
 * 29.05.2017
 * Genre
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class Genre {
    private int id;
    private String genre;
    private int idFilm;

    public Genre() {
    }

    public Genre(Builder builder){
        this.id = builder.id;
        this.genre = builder.genre;
        this.idFilm =  builder.idFilm;
    }
    public static class Builder{
        private int id;
        private String genre;
        private int idFilm;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder genre(String genre){
            this.genre = genre;
            return this;
        }
        public Builder idFilm(int idFilm){
            this.idFilm = idFilm;
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

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
