package ru.itis.main.models;

/**
 * Created by Аюпов Аяз on 28.04.2017.
 */
public class Auto implements Model{
    private int id;
    private String model;
    private String color;
    private double carMileage;
    private boolean used;

    public Auto(String model, String color, double carMileage,boolean used) {
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.used = used;
    }

    public Auto(int id, String model, String color, double carMileage,boolean used) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getCarMileage() {
        return carMileage;
    }

    @Override
    public String toString() {
        return id+" "+model+" "+color+" "+carMileage+" "+used;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Auto){
            Auto that = (Auto)obj;
            return this.id == that.id
                    && this.model.equals(that.model)
                    && this.color.equals(that.color)
                    && this.carMileage == that.carMileage
                    && this.used == that.used;
        }return false;
    }
}
