package org.example;

public class Taxi<T extends Person> extends Car<T> {
    public Taxi(int maxSeats) {
        super(maxSeats);
    }
}
