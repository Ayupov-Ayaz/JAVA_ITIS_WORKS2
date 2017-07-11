package ru.itis.dto;

/**
 * 26.06.2017
 * UserDto
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class UserDto {
    private int id;
    private int age;
    private String name;
    private String login;

    public UserDto() {
    }

    public UserDto(int id, int age, String name, String login) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

