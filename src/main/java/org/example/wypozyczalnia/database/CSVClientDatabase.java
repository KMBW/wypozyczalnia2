package org.example.wypozyczalnia.database;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.RentingPosition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVClientDatabase {
    private static CSVClientDatabase csvClientDatabase;
    private String fileName;

    public static CSVClientDatabase getInstance(String fileName) {
        if (csvClientDatabase == null) {
            csvClientDatabase = new CSVClientDatabase(fileName);
        }
        return csvClientDatabase;
    }

    private CSVClientDatabase(String fileName) {
        this.fileName = fileName;
    }

    public void saveClientPosition(Client position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(position.toString() + System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Client>  loadAllClients() {
        List<String[]> parametersList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            parametersList = reader.readAll();
            //parametersList.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Client> client = parametersList.stream()
                .map((p) -> new Client(p))
                .collect(Collectors.toList());

        return  client;
    }

    public Client getClientById(int id) {
        return null;
    }



    }


