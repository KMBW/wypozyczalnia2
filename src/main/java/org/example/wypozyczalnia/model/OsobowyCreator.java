package org.example.wypozyczalnia.model;

public class OsobowyCreator extends VehicleCreator{
    @Override
    public Vehicle createVehicle() {
        return new Osobowy();
    }
}
