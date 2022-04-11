package org.example.wypozyczalnia.iterator;


import org.example.wypozyczalnia.model.Car;

import java.util.List;


public class CarCollection implements Collection<Car>{

    private List<Car> car;

    public CarCollection(List<Car> car) {
        this.car = car;
    }

    @Override
    public Iterator<Car> createIterator() {

        return new CarIterator(this);
    }

    public List<Car> getCar() {

        return car;
    }


}
