package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RoadTest {

    private Road road;
    private Bus<Person> bus;
    private Taxi<Person> taxi;
    private FireTruck fireTruck;
    private PoliceCar policeCar;

    @Before
    public void setUp() {
        bus = new Bus<>(50);
        taxi = new Taxi<>(4);
        fireTruck = new FireTruck(2);
        policeCar = new PoliceCar(2);

        List<Vehicle<?>> vehicles = new ArrayList<>();
        vehicles.add(bus);
        vehicles.add(taxi);
        vehicles.add(fireTruck);
        vehicles.add(policeCar);
        road = new Road(vehicles);
    }

    @Test
    public void testGetCountOfHumansInitially() {
        assertEquals(0, road.getCountOfHumans());
    }

    @Test
    public void testGetCountOfHumansAfterBoarding() throws Exception {
        bus.boardPassenger(new Person("Bus Passenger 1"));
        taxi.boardPassenger(new Person("Taxi Passenger 1"));
        fireTruck.boardPassenger(new Firefighter("Firefighter 1"));
        policeCar.boardPassenger(new PoliceOfficer("Police Officer 1"));

        assertEquals(4, road.getCountOfHumans());

        policeCar.boardPassenger(new PoliceOfficer("Police Officer 2"));
        assertEquals(5, road.getCountOfHumans());
    }

    @Test
    public void testAddCarToRoad() {
        assertEquals(0, road.getCountOfHumans());

        Taxi<Person> newTaxi = new Taxi<>(2);
        road.addCarToRoad(newTaxi);

        assertEquals(0, road.getCountOfHumans());

        try {
            newTaxi.boardPassenger(new Person("New Taxi Passenger"));
            assertEquals(1, road.getCountOfHumans());
        } catch (Exception e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }
}
