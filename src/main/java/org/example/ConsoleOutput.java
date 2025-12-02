package org.example;

public class ConsoleOutput {
    public static synchronized void print(String message) {
        System.out.println(message);
    }
}