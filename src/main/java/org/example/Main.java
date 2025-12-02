package org.example;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str1 = "Hello world";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str2 = scanner.nextLine();
        scanner.close();

        System.out.println("\nBefore change:");
        System.out.println("Initialized string: " + str1);
        System.out.println("Your entered string: " + str2);

        changeStringValue(str1, "Replaced 1");
        changeStringValue(str2, "Replaced 2");

        System.out.println("\nAfter change");
        System.out.println("Initialized string: " + str1);
        System.out.println("Your entered string: " + str2);
    }

    private static void changeStringValue(String str, String newValue) throws NoSuchFieldException, IllegalAccessException {
        Class<?> stringClass = String.class;

        Field valueField = stringClass.getDeclaredField("value");
        valueField.setAccessible(true);

        byte[] valueArray = newValue.getBytes(StandardCharsets.UTF_8);
        byte[] newBackingArray = new byte[valueArray.length];
        System.arraycopy(valueArray, 0, newBackingArray, 0, valueArray.length);
        valueField.set(str, newBackingArray);
    }
}