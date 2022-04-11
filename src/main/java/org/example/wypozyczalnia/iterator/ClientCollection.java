package org.example.wypozyczalnia.iterator;

import org.example.wypozyczalnia.model.Client;

import java.util.List;

public class ClientCollection implements Collection<Client> {

    private List<Client> client;

    public ClientCollection(List<Client> client) {
        this.client = client;
    }

    @Override
    public Iterator<Client> createIterator() {
        return new ClientIterator(this);
    }

    public List<Client> getClient(){
        return client;
    }
}
