package org.example.wypozyczalnia.model;

import java.util.HashMap;

public class Car implements Record {
    private static int counter = 1;
    private int id = counter++;
    private String marka;
    private String model;
    private int cost;

    public Car(String marka, String model) {
        this.marka = marka;
        this.model = model;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static void setCounter(int counter) {
        Car.counter = counter;
    }
    public Car (String[] properties) {
            this.id = Integer.parseInt(properties[0]);
            this.marka = properties[1];
            this.model = properties[2];
            this.cost = Integer.parseInt(properties[3]);
        }


    public Car(String marka, String model, String cost) {
        this.marka = marka;
        this.model = model;
        this.cost = Integer.parseInt(cost);
    }

    public HashMap<String, String> getPropertiesForValidation() {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("marka", marka);
        properties.put("model", model);
        properties.put("cost", Integer.toString(cost));
        return properties;
    }

    @Override
    public String toString() {return id + "," + marka + "," + model + "," + cost;}
}
