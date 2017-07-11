package ru.itis.models;

import javax.persistence.*;
import java.util.Set;

/**
 * 26.06.2017
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

    @Column(name = "name")
    private String name;

    @Column(name ="password_hash")
    private String hashPassword;

    @Column
    private String token;

    @Column
    private int age;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User() {
    }
    public User(Builder b){
        this.id = b.id;
        this.age = b.age;
        this.name = b.name;
        this.hashPassword = b.hashPassword;
        this.token = b.token;
        this.roles = b.roles;
        this.login = b.login;
    }

    public static class Builder{
        private int id;
        private String login;
        private int age;
        private String name;
        private String hashPassword;
        private String token;
        private Set<Role> roles;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder name(String username){
            this.name = username;
            return this;
        }
        public Builder hashPassword(String hashPassword){
            this.hashPassword = hashPassword;
            return this;
        }
        public Builder token(String token){
            this.token = token;
            return this;
        }
        public Builder roles(Set<Role> roles){
            this.roles = roles;
            return this;
        }
        public Builder login(String login){
            this.login = login;
            return this;
        }
        public User build(){
            return new User(this);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
