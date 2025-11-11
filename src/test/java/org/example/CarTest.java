package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    private Car<Person> car;

    @BeforeEach
    public void setUp() {
        car = new Car<>(4);
    }

    @Test
    public void testBoardPassenger() throws Exception {
        car.boardPassenger(new Person("Car Passenger 1"));
        assertEquals(1, car.getCurrentPassengerCount());
    }

    @Test
    public void getMaxSeats() {
        assertEquals(4, car.getMaxSeats());
    }

    @Test
    public void testBoardFirefighter() throws Exception {
        Firefighter firefighter = new Firefighter("Firefighter 1");
        car.boardPassenger(firefighter);
        assertEquals(1, car.getCurrentPassengerCount());
    }

    @Test
    public void testBoardPoliceOfficer() throws Exception {
        PoliceOfficer policeOfficer = new PoliceOfficer("Police Officer 1");
        car.boardPassenger(policeOfficer);
        assertEquals(1, car.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkPassenger() throws Exception {
        Person passenger = new Person("Car Passenger 1");
        car.boardPassenger(passenger);
        car.disembarkPassenger(passenger);
        assertEquals(0, car.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkFirefighter() throws Exception {
        Firefighter firefighter = new Firefighter("Firefighter 1");
        car.boardPassenger(firefighter);
        car.disembarkPassenger(firefighter);
        assertEquals(0, car.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkPoliceOfficer() throws Exception {
        PoliceOfficer policeOfficer = new PoliceOfficer("Police Officer 1");
        car.boardPassenger(policeOfficer);
        car.disembarkPassenger(policeOfficer);
        assertEquals(0, car.getCurrentPassengerCount());
    }

    @Test
    public void testExceedCapacity() throws Exception {
        for (int i = 1; i <= 4; i++) {
            car.boardPassenger(new Person("Passenger " + i));
        }
        assertEquals(4, car.getCurrentPassengerCount());

        Exception exception = assertThrows(Exception.class, () ->
                car.boardPassenger(new Person("Extra Passenger")));
        assertEquals("No seats available", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentPassenger() {
        Exception exception = assertThrows(Exception.class, () ->
                car.disembarkPassenger(new Person("Nonexistent Passenger")));
        assertEquals("Nonexistent Passenger is not aboard this vehicle", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentFirefighter() {
        Exception exception = assertThrows(Exception.class, () ->
                car.disembarkPassenger(new Firefighter("Nonexistent Firefighter")));
        assertEquals("Nonexistent Firefighter is not aboard this vehicle", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentPoliceOfficer() {
        Exception exception = assertThrows(Exception.class, () ->
                car.disembarkPassenger(new PoliceOfficer("Nonexistent Police Officer")));
        assertEquals("Nonexistent Police Officer is not aboard this vehicle", exception.getMessage());
    }
}
