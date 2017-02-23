package com.example.androidapp.countingassholes;

public class CarPacket {

    private int id;
    private String color, make;

    public CarPacket(int id, String color, String make) {
        this.id = id;
        this.color = color;
        this.make = make;
    }

    public CarPacket(String color, String make) {
        this.color = color;
        this.make = make;
    }

    public CarPacket() {

    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public void setMake(String newMake) {
        this.make = newMake;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }
}
