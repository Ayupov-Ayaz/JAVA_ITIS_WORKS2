package ru.itis.models;

/**
 * 04.06.2017
 * Frend @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
public class Frend {
    private int id;
    private String first_name;
    private String last_name;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Frend() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
