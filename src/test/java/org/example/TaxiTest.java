package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxiTest {

    private Taxi<Person> taxi;

    @BeforeEach
    public void setUp() {
        taxi = new Taxi<>(4);
    }

    @Test
    public void testBoardPassenger() throws Exception {
        taxi.boardPassenger(new Person("Car Passenger 1"));
        assertEquals(1, taxi.getCurrentPassengerCount());
    }

    @Test
    public void testBoardFirefighter() throws Exception {
        Firefighter firefighter = new Firefighter("Firefighter 1");
        taxi.boardPassenger(firefighter);
        assertEquals(1, taxi.getCurrentPassengerCount());
    }

    @Test
    public void testBoardPoliceOfficer() throws Exception {
        PoliceOfficer policeOfficer = new PoliceOfficer("Police Officer 1");
        taxi.boardPassenger(policeOfficer);
        assertEquals(1, taxi.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkPassenger() throws Exception {
        Person passenger = new Person("Car Passenger 1");
        taxi.boardPassenger(passenger);
        taxi.disembarkPassenger(passenger);
        assertEquals(0, taxi.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkFirefighter() throws Exception {
        Firefighter firefighter = new Firefighter("Firefighter 1");
        taxi.boardPassenger(firefighter);
        taxi.disembarkPassenger(firefighter);
        assertEquals(0, taxi.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkPoliceOfficer() throws Exception {
        PoliceOfficer policeOfficer = new PoliceOfficer("Police Officer 1");
        taxi.boardPassenger(policeOfficer);
        taxi.disembarkPassenger(policeOfficer);
        assertEquals(0, taxi.getCurrentPassengerCount());
    }

    @Test
    public void testExceedCapacity() throws Exception {
        for (int i = 1; i <= 4; i++) {
            taxi.boardPassenger(new Person("Passenger " + i));
        }
        assertEquals(4, taxi.getCurrentPassengerCount());

        Exception exception = assertThrows(Exception.class, () ->
                taxi.boardPassenger(new Person("Extra Passenger")));
        assertEquals("No seats available", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentPassenger() {
        Exception exception = assertThrows(Exception.class, () ->
                taxi.disembarkPassenger(new Person("Nonexistent Passenger")));
        assertEquals("Nonexistent Passenger is not aboard this vehicle", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentFirefighter() {
        Exception exception = assertThrows(Exception.class, () ->
                taxi.disembarkPassenger(new Firefighter("Nonexistent Firefighter")));
        assertEquals("Nonexistent Firefighter is not aboard this vehicle", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentPoliceOfficer() {
        Exception exception = assertThrows(Exception.class, () ->
                taxi.disembarkPassenger(new PoliceOfficer("Nonexistent Police Officer")));
        assertEquals("Nonexistent Police Officer is not aboard this vehicle", exception.getMessage());
    }
}
