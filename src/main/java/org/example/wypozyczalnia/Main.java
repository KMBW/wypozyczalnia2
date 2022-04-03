package org.example.wypozyczalnia;


import org.example.wypozyczalnia.application.RentingPositionService;
import org.example.wypozyczalnia.console.ConsoleController;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.RentingPosition;

import java.io.Console;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        CSVClientDatabase csvClientDatabase = CSVClientDatabase.getInstance("clients.csv");
        CSVCarDatabase csvCarDatabase = CSVCarDatabase.getInstance("Car.csv");
        CSVRentingFileDatabase csvRentingFileDatabase = CSVRentingFileDatabase.getInstance("rentingPosition.csv");
        List<Car> cars = csvCarDatabase.loadAllCars();
        Car carWithMaxId = cars.stream()
                .max(Comparator.comparingInt(car -> car.getId()))
                .get();
        Car.setCounter(carWithMaxId.getId() + 1);
        List<Client> clients = csvClientDatabase.loadAllClients();
        Car clientWithMaxId = cars.stream()
                .max(Comparator.comparingInt(client -> client.getId()))
                .get();
        Client.setCounter(clientWithMaxId.getId() + 1);
        List<RentingPosition> rentingPositions = csvRentingFileDatabase.loadAllRentingPositions();
        RentingPosition rentingPostitionWithMaxId = rentingPositions.stream()
                .max(Comparator.comparingInt(rentingPosition -> rentingPosition.getId()))
                .get();
        RentingPosition.setCounter(rentingPostitionWithMaxId.getId() + 1);
       ConsoleController consoleController = new ConsoleController();
       consoleController.Menu();

    }
}
