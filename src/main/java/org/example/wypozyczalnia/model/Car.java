package org.example.wypozyczalnia.model;

public class Car {
    private static int counter = 1;
    private int id = counter++;
    private String marka;
    private String model;
    private int cost;

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

    public Car (String[] properties) {
            this.id = Integer.parseInt(properties[0]);
            this.marka = properties[1];
            this.model = properties[2];
        }

    public Car() {
    }

    public Car(String marka, String model) {
        this.marka = marka;
        this.model = model;
    }

    @Override

    public String toString() {return id + "," + marka + "," + model + "," + cost;}
}
