package org.example.wypozyczalnia;


import org.example.wypozyczalnia.application.RentingPositionService;
import org.example.wypozyczalnia.model.RentingPosition;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        RentingPosition rentingPosition = new RentingPosition(1,"Honda", LocalDateTime.now(), LocalDateTime.now(), 1000);
        RentingPosition rentingPosition2 = new RentingPosition(2,"BMW", LocalDateTime.now(), LocalDateTime.now(), 4000);
        RentingPositionService rentingPositionService = new RentingPositionService();
        rentingPositionService.rentCar(rentingPosition);
        rentingPositionService.showAllRentingPositions().forEach(rentingPosition1 -> System.out.println(rentingPosition1.toString()));
        rentingPositionService.rentCar(rentingPosition2);
        rentingPositionService.showAllRentingPositions().forEach(rentingPosition1 -> System.out.println(rentingPosition1.toString()));

    }
}
