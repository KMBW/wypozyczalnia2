package org.example.wypozyczalnia.model;

public class Client {
    private static int counter = 1;
    private int id = counter++;
    private String imie;
    private String nazwisko;
    private String email;
    private Address adres;

    public static void setCounter(int counter) {
        Client.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAdres() {
        return adres;
    }

    public Client(String[] properties) {
        this.id = Integer.parseInt(properties[0]);
        this.imie = properties[1];
        this.nazwisko = properties[2];
        this.email = properties [3];
    }

    public Client() {
    }

    public Client(String imie, String nazwisko, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }



    public void setAdres(Address adres) {
        this.adres = adres;
    }

    @Override

    public String toString() {
        return id + "," + imie + "," + nazwisko + "," + email;
    }

}
