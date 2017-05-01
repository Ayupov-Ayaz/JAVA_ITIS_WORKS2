package ru.itis.main.models;

/**
 * Created by Аюпов Аяз on 28.04.2017.
 */
public class User implements Model{
    private int id;
    private String login;
    private String password;
    private String name;
    private int age;

    public User(int id, String login, String password, String name, int age) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public User(String login, String password, String name, int age) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  id +" "
                + login +" "
                + password +" "
                + name +" "
                + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof User){
            User that = (User)obj;
            return this.id == that.id
                    && this.login.equals(that.login)
                    && this.password.equals(that.password)
                    && this.name.equals(that.name)
                    && this.age == that.age;
        } return false;
    }
}

