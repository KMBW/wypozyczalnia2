package org.example.wypozyczalnia.iterator;

import org.example.wypozyczalnia.model.Car;
import org.example.wypozyczalnia.model.RentingPosition;

public class CarIterator implements Iterator<Car>{

    private CarCollection carCollection;
    private int currentIndex;

    public CarIterator(CarCollection carCollection) {
        this.carCollection = carCollection;
        this.currentIndex = 0;
    }

    @Override
    public Car getNext() {
        currentIndex++;
        return carCollection.getCar().get(currentIndex);
    }

    @Override
    public Car getCurrent() {

        return carCollection.getCar().get(currentIndex);
    }

    @Override
    public boolean hasNext() {

        return currentIndex + 1 < carCollection.getCar().size();
    }

}
