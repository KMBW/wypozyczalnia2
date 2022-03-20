package org.example.wypozyczalnia.application;


import org.example.wypozyczalnia.database.CSVCarDatabase;
import org.example.wypozyczalnia.database.CSVClientDatabase;
import org.example.wypozyczalnia.database.CSVRentingFileDatabase;
import org.example.wypozyczalnia.model.Car;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.RentingPosition;

import java.util.List;

public class RentingPositionService {
    CSVRentingFileDatabase csvRentingFileDatabase;
    CSVClientDatabase csvClientDatabase;
    CSVCarDatabase csvCarDatabase;

    public RentingPositionService() {
        csvRentingFileDatabase = CSVRentingFileDatabase.getInstance("rentingPosition.csv");
        csvClientDatabase = CSVClientDatabase.getInstance("clients.csv");
        csvCarDatabase = CSVCarDatabase.getInstance("Car.csv");
    }


    public void rentCar(RentingPosition rentingPosition){csvRentingFileDatabase.saveRentingPosition(rentingPosition);}
    public void addClient(Client client) {
        csvClientDatabase.saveClientPosition(client);
    }
    public void addCar(Car car) {csvCarDatabase.saveCarPosition(car);}

    public List<RentingPosition> showAllRentingPositions(){
        return csvRentingFileDatabase.loadAllRentingPositions();
    }
}
