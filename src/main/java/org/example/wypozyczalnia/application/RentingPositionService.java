package org.example.wypozyczalnia.application;


import org.example.wypozyczalnia.database.CSVCarDatabase;
import org.example.wypozyczalnia.database.CSVClientDatabase;
import org.example.wypozyczalnia.database.CSVRentingFileDatabase;
import org.example.wypozyczalnia.model.Car;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.RentingPosition;

import java.util.List;

public class RentingPositionService {
    private final CSVRentingFileDatabase csvRentingFileDatabase;
    private final CSVClientDatabase csvClientDatabase;
    private final CSVCarDatabase csvCarDatabase;
    private final CarValidationService carValidationService;
    private final CarCostCalculator carCostCalculator;

    public RentingPositionService() {
        csvRentingFileDatabase = CSVRentingFileDatabase.getInstance("rentingPosition.csv");
        csvClientDatabase = CSVClientDatabase.getInstance("clients.csv");
        csvCarDatabase = CSVCarDatabase.getInstance("Car.csv");
        carValidationService = new CarValidationService();
        carCostCalculator = new CarCostCalculatorAdapter();
    }

    public void rentCar(RentingPosition rentingPosition){
        rentingPosition.setOplacono(false);
        Car car = csvCarDatabase.getCarById(rentingPosition.getCarId());
        rentingPosition.setTotalCost((int) (rentingPosition.getRentingPeriodInDays() * car.getCost()));
        csvRentingFileDatabase.saveRentingPosition(rentingPosition);
    }
    public void addClient(Client client) {
        csvClientDatabase.saveClientPosition(client);
    }
    public void addCar(Car car, int maksymalnaPredkosc) {
        double cost = carCostCalculator.calculateCarCost(maksymalnaPredkosc);
        car.setCost((int) cost);
        if(carValidationService.validateCarData(car)) {
            csvCarDatabase.saveCarPosition(car);
        }
        else {
            System.out.println("niepoprawne dane");
        }
    }

    public List<RentingPosition> showAllRentingPositions(){
        return csvRentingFileDatabase.loadAllRentingPositions();
    }
}
