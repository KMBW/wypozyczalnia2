package org.example.wypozyczalnia.model;

public class CiezarowyCreator extends VehicleCreator{
    @Override
    public Vehicle createVehicle() {
       return new Ciezarowy();
    }
}
