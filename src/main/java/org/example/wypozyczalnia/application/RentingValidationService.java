package org.example.wypozyczalnia.application;

import org.example.wypozyczalnia.model.RentingPosition;

public class RentingValidationService {

    public boolean validateRentingData(RentingPosition rentingPosition) {
        if (rentingPosition.getCarId() == 0) {
            return false;
        }
        return true;
    }
}
