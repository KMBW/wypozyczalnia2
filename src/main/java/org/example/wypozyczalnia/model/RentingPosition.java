package org.example.wypozyczalnia.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class RentingPosition implements Record{

    private static int counter = 1;
    private int id;
    private int carId;
    private LocalDateTime startRentDate;
    private LocalDateTime endRentDate;
    private int clientId;
    int totalCost;
    boolean oplacono;

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
        this.totalCost = Integer.parseInt(properties[5]);
        this.oplacono = Boolean.parseBoolean(properties[6]);


    }

    public static void setCounter(int counter) {
        RentingPosition.counter = counter;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean czyOplacono() {
        return oplacono;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setOplacono(boolean oplacono) {
        this.oplacono = oplacono;
    }

    public int getCarId() {
        return carId;
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

    public long getRentingPeriodInDays() {
        return ChronoUnit.DAYS.between(startRentDate, endRentDate);
    }

    public HashMap<String, String> getPropertiesForValidation() {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("carId", Integer.toString(carId));
        properties.put("startRentDate", startRentDate.toString());
        properties.put("endRentDate", endRentDate.toString());
        properties.put("totalCost", Integer.toString(totalCost));
        properties.put("oplacono", Boolean.toString(oplacono));
        return properties;
    }

    @Override
    public String toString() {
        return id + "," + carId + "," + startRentDate + "," + endRentDate + ","  + clientId + "," + totalCost + "," + oplacono;
    }
}