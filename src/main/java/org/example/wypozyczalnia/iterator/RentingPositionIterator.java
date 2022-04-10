package org.example.wypozyczalnia.iterator;

import org.example.wypozyczalnia.model.RentingPosition;

public class RentingPositionIterator implements Iterator<RentingPosition>{

    private RentingPositionsCollection rentingPositionsCollection;
    private int currentIndex;

    public RentingPositionIterator(RentingPositionsCollection rentingPositionsCollection) {
        this.rentingPositionsCollection = rentingPositionsCollection;
        this.currentIndex = 0;
    }

    @Override
    public RentingPosition getNext() {
        currentIndex++;
        return rentingPositionsCollection.getRentingPositions().get(currentIndex);
    }

    @Override
    public RentingPosition getCurrent() {
        return rentingPositionsCollection.getRentingPositions().get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < rentingPositionsCollection.getRentingPositions().size();
    }
}
