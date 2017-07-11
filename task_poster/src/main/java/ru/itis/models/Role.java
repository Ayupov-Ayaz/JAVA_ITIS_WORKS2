package ru.itis.models;

import javax.persistence.*;
import java.util.Set;

/**
 * 26.06.2017
 * Role
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }
    public Role(Builder b){
        this.id = b.id;
        this.role = b.role;
        this.users = b.users;
    }
    public static class Builder{
        private int id;
        private String role;
        private Set<User> users;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder role(String role){
            this.role = role;
            return this;
        }
        public Builder users(Set<User> users){
            this.users = users;
            return this;
        }
        public Role build(){
            return new Role(this);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
