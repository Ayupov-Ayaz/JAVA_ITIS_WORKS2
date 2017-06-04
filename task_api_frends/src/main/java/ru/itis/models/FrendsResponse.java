package ru.itis.models;

import java.util.List;

/**
 * 04.06.2017
 * FrendsResponse @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
public class FrendsResponse {
    private List<Frend> response;

    public FrendsResponse() {
    }

    public List<Frend> getResponse() {
        return response;
    }

    public void setResponse(List<Frend> response) {
        this.response = response;
    }
}
