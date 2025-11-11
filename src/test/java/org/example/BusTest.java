package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BusTest {

    private Bus<Person> bus;

    @BeforeEach
    public void setUp() {
        bus = new Bus<>(50);
    }

    @Test
    public void testBoardPassenger() throws Exception {
        bus.boardPassenger(new Person("Passenger 1"));
        assertEquals(1, bus.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkPassenger() throws Exception {
        Person passenger = new Person("Passenger 1");
        bus.boardPassenger(passenger);
        bus.disembarkPassenger(passenger);
        assertEquals(0, bus.getCurrentPassengerCount());
    }

    @Test
    public void testExceedCapacity() throws Exception {
        for (int i = 1; i <= 50; i++) {
            bus.boardPassenger(new Person("Passenger " + i));
        }
        assertEquals(50, bus.getCurrentPassengerCount());

        Exception exception = assertThrows(Exception.class, () ->
                bus.boardPassenger(new Person("Extra Passenger")));
        assertEquals("No seats available", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentPassenger() {
        Exception exception = assertThrows(Exception.class, () ->
                bus.disembarkPassenger(new Person("Nonexistent Passenger")));
        assertEquals("Nonexistent Passenger is not aboard this vehicle", exception.getMessage());
    }
}

