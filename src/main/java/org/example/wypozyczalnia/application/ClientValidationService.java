package org.example.wypozyczalnia.application;

import org.example.wypozyczalnia.model.Client;

public class ClientValidationService {

    public boolean validateClientData(Client client) {
        if (client.getImie().isEmpty()) {
            return false;
        }

        if (client.getNazwisko().isEmpty()) {
            return false;
        }
        return true;
    }
}
