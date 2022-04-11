package org.example.wypozyczalnia.application;


import org.example.wypozyczalnia.database.CSVCarDatabase;
import org.example.wypozyczalnia.database.CSVClientDatabase;
import org.example.wypozyczalnia.database.CSVRentingFileDatabase;
import org.example.wypozyczalnia.iterator.CarCollection;
import org.example.wypozyczalnia.iterator.ClientCollection;
import org.example.wypozyczalnia.iterator.RentingPositionsCollection;
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
    private final ClientValidationService clientValidationService;
    private final RentingValidationService rentingValidationService;

    public RentingPositionService() {
        csvRentingFileDatabase = CSVRentingFileDatabase.getInstance("rentingPosition.csv");
        csvClientDatabase = CSVClientDatabase.getInstance("clients.csv");
        csvCarDatabase = CSVCarDatabase.getInstance("Car.csv");
        carValidationService = new CarValidationService();
        carCostCalculator = new CarCostCalculatorAdapter();
        clientValidationService = new ClientValidationService();
        rentingValidationService = new RentingValidationService();
    }

    public void rentCar(RentingPosition rentingPosition){
        rentingPosition.setOplacono(false);
        Car car = csvCarDatabase.getCarById(rentingPosition.getCarId());
        rentingPosition.setTotalCost((int) (rentingPosition.getRentingPeriodInDays() * car.getCost()));
        if (rentingValidationService.validateRentingData(rentingPosition)) {
            csvRentingFileDatabase.saveRentingPosition(rentingPosition);
        }
        else  {
            System.out.println("niepoprawne dane");
        }
    }
    public void addClient(Client client) {
        if (clientValidationService.validateClientData(client)) {
            csvClientDatabase.saveClientPosition(client);}
        else  {
            System.out.println("niepoprawne dane");
        }
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

    public RentingPositionsCollection showAllRentingPositions(){
        return new RentingPositionsCollection(csvRentingFileDatabase.loadAllRentingPositions());
    }
    public ClientCollection showAllClients() {return new ClientCollection(csvClientDatabase.loadAllClients()) ;}
    public CarCollection showAllCars() {return new CarCollection(csvCarDatabase.loadAllCars()) ;}
}
