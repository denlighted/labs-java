package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PoliceCarTest {

    private PoliceCar policeCar;

    @Before
    public void setUp() {
        policeCar = new PoliceCar(2);
    }

    @Test
    public void testBoardPoliceOfficer() throws Exception {
        PoliceOfficer policeOfficer = new PoliceOfficer("Police Officer 1");
        policeCar.boardPassenger(policeOfficer);
        assertEquals(1, policeCar.getCurrentPassengerCount());
    }

    @Test
    public void testDisembarkPoliceOfficer() throws Exception {
        PoliceOfficer policeOfficer = new PoliceOfficer("Police Officer 1");
        policeCar.boardPassenger(policeOfficer);
        policeCar.disembarkPassenger(policeOfficer);
        assertEquals(0, policeCar.getCurrentPassengerCount());
    }

    @Test
    public void testExceedCapacity() throws Exception {
        policeCar.boardPassenger(new PoliceOfficer("Police Officer 1"));
        policeCar.boardPassenger(new PoliceOfficer("Police Officer 2"));
        assertEquals(2, policeCar.getCurrentPassengerCount());

        Exception exception = assertThrows(Exception.class, () ->
                policeCar.boardPassenger(new PoliceOfficer("Extra Police Officer")));
        assertEquals("No seats available", exception.getMessage());
    }

    @Test
    public void testDisembarkNonExistentPoliceOfficer() {
        Exception exception = assertThrows(Exception.class, () ->
                policeCar.disembarkPassenger(new PoliceOfficer("Nonexistent Police Officer")));
        assertEquals("Nonexistent Police Officer is not aboard this vehicle", exception.getMessage());
    }
}
