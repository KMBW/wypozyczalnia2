package org.example.wypozyczalnia.application;

public class CarCostCalculatorAdapter implements CarCostCalculator{

    CarCostCalculatorMPH carCostCalculatorMPH = new CarCostCalculatorMPH();

    public double calculateCarCost(int predkoscKMPH) {
        double predkoscMPH = predkoscKMPH / 1.6;
        return carCostCalculatorMPH.calculateCost(predkoscMPH);
    }
}
