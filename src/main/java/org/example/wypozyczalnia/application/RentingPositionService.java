package org.example.wypozyczalnia.application;


import org.example.wypozyczalnia.database.CSVRentingFileDatabase;
import org.example.wypozyczalnia.model.RentingPosition;

import java.util.List;

public class RentingPositionService {
    CSVRentingFileDatabase csvRentingFileDatabase;

    public RentingPositionService() {
        csvRentingFileDatabase = CSVRentingFileDatabase.getInstance("rentingPosition.csv");
    }

    public void rentCar(RentingPosition rentingPosition){
        //to sie uzupelni potem elo, zasady sprawdzajace dla naszego modelu biznesowego
        csvRentingFileDatabase.saveRentingPosition(rentingPosition);
    }

    public List<RentingPosition> showAllRentingPositions(){
        return csvRentingFileDatabase.loadAllRentingPositions();
    }
}
