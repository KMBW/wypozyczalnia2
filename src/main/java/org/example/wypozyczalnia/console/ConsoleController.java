package org.example.wypozyczalnia.console;


import org.example.wypozyczalnia.application.RentingPositionService;
import org.example.wypozyczalnia.database.CSVRentingFileDatabase;
import org.example.wypozyczalnia.iterator.Collection;
import org.example.wypozyczalnia.iterator.Iterator;
import org.example.wypozyczalnia.model.Car;
import org.example.wypozyczalnia.model.Client;
import org.example.wypozyczalnia.model.RentingPosition;
import org.example.wypozyczalnia.template.AddRecord;
import org.example.wypozyczalnia.template.AddRentingPosition;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleController {
    Scanner scanner = new Scanner(System.in);
    // renting position service jest fasadą
    RentingPositionService service = new RentingPositionService();
    AddRecord addRecordService;

    public void Menu() {
        while(true) {
            System.out.println("Wybierz akcję \n");
            System.out.println("1. Dodaj klienta | 2. Dodaj Pojazd | 3. Dodaj wypożyczenie | 4. Wyświetl wszystkie wypożyczenia | 5. Wyświetl wszystkich klientów | 6. Wyświetl wszystkie samochody");
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
                System.out.println("Podaj maksymalna predkość samochodu w kilometrach na godzine \n");
                int maksymalnaPredkosc = Integer.parseInt(scanner.next());
                service.addCar(new Car (marka, model), maksymalnaPredkosc);
                System.out.println("Pomyślnie dodano pojazd");
            }

            if(input == 3) {
                addRecordService = new AddRentingPosition(CSVRentingFileDatabase.getInstance("rentingPosition.csv"));
                System.out.println("Podaj ID Samochodu \n");
                int carId = Integer.parseInt(scanner.next());
                System.out.println("Podaj datę wypożyczenia \n");
                System.out.println("Podaj rok \n");
                int rokStart = Integer.parseInt(scanner.next());
                System.out.println("Podaj miesiac \n");
                int miesiacStart = Integer.parseInt(scanner.next());
                System.out.println("Podaj dzien \n");
                int dzienStart = Integer.parseInt(scanner.next());
                LocalDateTime startRentDate = LocalDateTime.of(rokStart, miesiacStart, dzienStart, 0, 0);
                System.out.println("Podaj datę oddania \n");
                System.out.println("Podaj rok \n");
                int rokEnd = Integer.parseInt(scanner.next());
                System.out.println("Podaj miesiac \n");
                int miesiacEnd = Integer.parseInt(scanner.next());
                System.out.println("Podaj dzien \n");
                int dzienEnd = Integer.parseInt(scanner.next());
                LocalDateTime endRentDate = LocalDateTime.of(rokEnd, miesiacEnd, dzienEnd, 0, 0);
                System.out.println("Podaj ID Klienta \n");
                int clientId = Integer.parseInt(scanner.next());
                addRecordService.addRecord(new RentingPosition(carId, startRentDate, endRentDate, clientId));
                //service.rentCar(new RentingPosition(carId, startRentDate, endRentDate, clientId));
                System.out.println("Pomyślnie dodano wypożyczenie");
            }
            if (input == 4) {
                Collection<RentingPosition> collection = service.showAllRentingPositions();
                Iterator<RentingPosition> iterator = collection.createIterator();
                System.out.println(iterator.getCurrent());
                while(iterator.hasNext()) {
                    System.out.println(iterator.getNext());
                }

            }

            if (input == 5) {
                Collection<Client> collection = service.showAllClients();
                Iterator<Client> iterator = collection.createIterator();
                System.out.println(iterator.getCurrent());
                while(iterator.hasNext()) {
                    System.out.println(iterator.getNext());
                }
            }

            if (input == 6) {
                Collection<Car> collection = service.showAllCars();
                Iterator<Car> iterator = collection.createIterator();
                System.out.println(iterator.getCurrent());
                while(iterator.hasNext()) {
                    System.out.println(iterator.getNext());
                }
            }


        }
    }
}
