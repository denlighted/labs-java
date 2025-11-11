package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    public void testPersonCreation() {
        Person person = new Person("John Doe");
        assertEquals("John Doe", person.getName());
    }
}