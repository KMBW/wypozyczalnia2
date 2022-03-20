package org.example.wypozyczalnia.console;


import org.example.wypozyczalnia.application.RentingPositionService;
import org.example.wypozyczalnia.model.Car;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.RentingPosition;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleController {
    Scanner scanner = new Scanner(System.in);
    RentingPositionService service = new RentingPositionService();


    public void Menu() {
        while(true) {
            System.out.println("Wybierz akcję \n");
            System.out.println("1. Dodaj klienta | 2. Dodaj Pojazd | 3. Dodaj wypożyczenie ");
            int input = scanner.nextInt();
            if(input == 1) {
                System.out.println("Podaj imię \n");
                String imie = scanner.next();
                System.out.println("Podaj nazwisko \n");
                String nazwisko = scanner.next();
                System.out.println("Podaj adres email \n");
                String email = scanner.next();
                service.addClient(new Client(imie, nazwisko, email));
                System.out.println("Pomyślnie dodano klienta");
            }

            if(input == 2) {
                System.out.println("Podaj markę \n");
                String marka = scanner.next();
                System.out.println("Podaj model \n");
                String model = scanner.next();
                System.out.println("Podaj koszt wynajmu \n");
                String cost = scanner.next();
                service.addCar(new Car (marka, model, cost));
                System.out.println("Pomyślnie dodano pojazd");
            }

            if(input == 3) {
                System.out.println("Podaj ID Samochodu \n");
                int carId = Integer.parseInt(scanner.next());
                System.out.println("Podaj datę wypożyczenia \n");
                LocalDateTime startRentDate = LocalDateTime.parse(scanner.next());
                System.out.println("Podaj datę oddania \n");
                LocalDateTime endRentDate = LocalDateTime.parse(scanner.next());
                System.out.println("Podaj ID Klienta \n");
                int clientId = Integer.parseInt(scanner.next());
                service.rentCar(new RentingPosition(carId, startRentDate, endRentDate, clientId));
                System.out.println("Pomyślnie dodano wypożyczenie");
            }


        }
    }
}
