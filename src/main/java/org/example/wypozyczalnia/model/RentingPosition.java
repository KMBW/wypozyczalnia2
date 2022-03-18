package org.example.wypozyczalnia.model;

import java.time.LocalDateTime;

public class RentingPosition {

    private int id;
    private String carName;
    private LocalDateTime startRentDate;
    private LocalDateTime endRentDate;
    private int cost;

    public RentingPosition(int id, String carName, LocalDateTime startRentDate, LocalDateTime endtRentDate, int cost) {
        this.id = id;
        this.carName = carName;
        this.startRentDate = startRentDate;
        this.endRentDate = endtRentDate;
        this.cost = cost;
    }

    public RentingPosition(String[] properties) {
        this.id = Integer.parseInt(properties[0]);
        this.carName = properties[1];
        this.startRentDate = LocalDateTime.parse(properties[2]);
        this.endRentDate = LocalDateTime.parse(properties[3]);
        this.cost = Integer.parseInt(properties[4]);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public LocalDateTime getStartRentDate() {
        return startRentDate;
    }

    public void setStartRentDate(LocalDateTime startRentDate) {
        this.startRentDate = startRentDate;
    }

    public LocalDateTime getEndRentDate() {
        return endRentDate;
    }

    public void setEndRentDate(LocalDateTime endRentDate) {
        this.endRentDate = endRentDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return id + "," + carName + "," + startRentDate + "," + endRentDate + "," + cost;
    }
}