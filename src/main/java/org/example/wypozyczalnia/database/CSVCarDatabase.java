package org.example.wypozyczalnia.database;

import com.opencsv.CSVReader;
import org.example.wypozyczalnia.model.Car;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.Vehicle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVCarDatabase {
    private static CSVCarDatabase csvCarDatabase;
    private String fileName;

    public static CSVCarDatabase getInstance(String fileName) {
        if (csvCarDatabase ==null) {
            csvCarDatabase = new CSVCarDatabase(fileName);
        }
        return csvCarDatabase;
    }

    private CSVCarDatabase(String fileName) {this.fileName = fileName;}

    public void saveCarPosition(Car position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(position.toString() + System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> loadAllCars() {
        List<String[]> parametersList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            parametersList = reader.readAll();
            //parametersList.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Car> car = parametersList.stream()
                .map((p) -> new Car(p))
                .collect(Collectors.toList());

        return  car;
    }

    public Car getCarById(int id) {
        List<Car> cars = loadAllCars();
        return cars.stream().filter((car) -> car.getId()==id).collect(Collectors.toList()).get(0);
    }
}
