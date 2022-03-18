package org.example.wypozyczalnia.database;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.example.wypozyczalnia.model.RentingPosition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVRentingFileDatabase {

    private static CSVRentingFileDatabase csvRentingFileDatabase;
    private String fileName;

    private CSVRentingFileDatabase(String fileName) {
        this.fileName = fileName;
    }

    public static CSVRentingFileDatabase getInstance(String fileName) {
        if(csvRentingFileDatabase == null) {
            csvRentingFileDatabase = new CSVRentingFileDatabase(fileName);
        }
        return csvRentingFileDatabase;
    }


    public void saveRentingPosition(RentingPosition position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(position.toString() + System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<RentingPosition>  loadAllRentingPositions() {
        List<String[]> parametersList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            parametersList = reader.readAll();
            //parametersList.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<RentingPosition> rentingPositions = parametersList.stream()
                .map((p) -> new RentingPosition(p))
                .collect(Collectors.toList());

        return  rentingPositions;
    }
}
