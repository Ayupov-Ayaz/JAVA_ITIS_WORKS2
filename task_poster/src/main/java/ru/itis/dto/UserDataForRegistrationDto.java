package ru.itis.dto;

/**
 * 26.06.2017
 * UserDataForRegistrationDto
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class UserDataForRegistrationDto {
     private String login;
     private String name;
     private String password;
     private int age;

    public UserDataForRegistrationDto() {
    }

    public UserDataForRegistrationDto(String login, String name, String password, int age) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
