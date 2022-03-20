package org.example.wypozyczalnia.model;

import java.time.LocalDateTime;

public class RentingPosition {

    private static int counter = 1;
    private int id;
    private int carId;
    private LocalDateTime startRentDate;
    private LocalDateTime endRentDate;
    private int clientId;

    public RentingPosition(int carId, LocalDateTime startRentDate, LocalDateTime endRentDate, int clientId) {
        this.id = counter++;
        this.carId = carId;
        this.startRentDate = startRentDate;
        this.endRentDate = endRentDate;
        this.clientId = clientId;
    }

    public RentingPosition(String[] properties) {
        this.id = Integer.parseInt(properties[0]);
        this.carId = Integer.parseInt(properties[1]);
        this.startRentDate = LocalDateTime.parse(properties[2]);
        this.endRentDate = LocalDateTime.parse(properties[3]);
        this.clientId = Integer.parseInt(properties[4]);


    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public String toString() {
        return id + "," + carId + "," + startRentDate + "," + endRentDate + ","  + clientId;
    }
}