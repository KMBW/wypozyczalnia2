package org.example.wypozyczalnia.model;

import java.util.HashMap;

public interface Record {

    HashMap<String, String> getPropertiesForValidation();
    String toString();
}
