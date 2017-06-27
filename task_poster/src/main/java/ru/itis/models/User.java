package ru.itis.models;

import javax.persistence.*;

/**
 * 27.06.2017
 * User
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String login;
    @Column(name = "password_hash")
    private String hashPassword;
    @Column
    private int age;

    public User() {
    }
    public User(Builder b){
        this.login = b.login;
        this.id = b.id;
        this.age = b.age;
        this.hashPassword = b.password;
    }
    public static class Builder{
        private int id;
        private int age;
        private String login;
        private String password;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder login(String login){
            this.login = login;
            return this;
        }  public Builder password(String password){
            this.password = password;
            return this;
        }
        public User buil(){
            return new User(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
