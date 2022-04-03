package org.example.wypozyczalnia.application;

import org.example.wypozyczalnia.model.Car;

public class CarValidationService {

    public boolean validateCarData(Car car) {
        if (car.getMarka().isEmpty()) {
            return false;
        }
        if (car.getModel().isEmpty()) {
            return false;
        }
        if (car.getCost() == 0) {
            return false;
        }
        return true;
    }
}
