package org.example.wypozyczalnia.template;

import org.example.wypozyczalnia.database.CSVRentingFileDatabase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class AddRentingPosition extends AddRecord{

    CSVRentingFileDatabase database;

    public AddRentingPosition(CSVRentingFileDatabase database) {
        this.database = database;
    }

    @Override
    public boolean validateData(HashMap<String, String> properties) {
        String endDateString = properties.get("endRentDate");
        LocalDateTime endRentDate = LocalDateTime.parse(endDateString);
        if(LocalDateTime.now().isAfter(endRentDate)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void saveToDatabase(String csv) {
        database.saveRentingPosition(csv);
    }
}
