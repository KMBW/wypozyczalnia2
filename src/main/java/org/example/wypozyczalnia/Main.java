package org.example.wypozyczalnia;


import org.example.wypozyczalnia.application.RentingPositionService;
import org.example.wypozyczalnia.console.ConsoleController;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.RentingPosition;

import java.io.Console;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        /* RentingPosition rentingPosition = new RentingPosition(1, LocalDateTime.now(), LocalDateTime.now(), 1);
        RentingPositionService rentingPositionService = new RentingPositionService();
        rentingPositionService.rentCar(rentingPosition);
        rentingPositionService.showAllRentingPositions().forEach(rentingPosition1 -> System.out.println(rentingPosition1.toString())); */

       ConsoleController consoleController = new ConsoleController();
       consoleController.Menu();

    }
}
