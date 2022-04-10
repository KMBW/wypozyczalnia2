package org.example.wypozyczalnia.template;

import org.example.wypozyczalnia.model.Record;

import java.util.HashMap;

public abstract class AddRecord {
    public void addRecord(Record record) {
        if (validateData(record.getPropertiesForValidation())) {
            saveToDatabase(record.toString());
        }
    }
    public abstract boolean validateData(HashMap<String, String> properties);
    public abstract void saveToDatabase(String csv);

}
