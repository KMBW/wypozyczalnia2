package org.example.wypozyczalnia.iterator;
import org.example.wypozyczalnia.model.Client;



public class ClientIterator implements Iterator<Client> {

    private ClientCollection clientCollection;
    private int currentIndex;

    public ClientIterator(ClientCollection clientCollection) {
        this.clientCollection = clientCollection;
        this.currentIndex = 0;
    }

    @Override
    public Client getNext() {
        currentIndex++;
        return clientCollection.getClient().get(currentIndex);
    }

    @Override
    public Client getCurrent() {
        return clientCollection.getClient().get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < clientCollection.getClient().size();
    }
}
