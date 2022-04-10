package org.example.wypozyczalnia.iterator;

import org.example.wypozyczalnia.model.RentingPosition;

import java.util.List;

public class RentingPositionsCollection implements Collection<RentingPosition>{

    private List<RentingPosition> rentingPositions;

    public RentingPositionsCollection(List<RentingPosition> rentingPositions) {
        this.rentingPositions = rentingPositions;
    }

    @Override
    public Iterator<RentingPosition> createIterator() {
        return new RentingPositionIterator(this);
    }

    public List<RentingPosition> getRentingPositions() {
        return rentingPositions;
    }
}