package org.example;

public class Bus<T extends Person> extends Vehicle<T> {
    public Bus(int maxSeats) {
        super(maxSeats);
    }
}


