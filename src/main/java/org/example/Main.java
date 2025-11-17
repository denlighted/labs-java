package org.example;

import java.util.Arrays;
import java.util.Scanner;

import static org.example.UniqueWords.findUniqueCharWords;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть слова через пробіл:");
        String input = scanner.nextLine();

        String[] words = input.split("\\s+");

        String[] result = findUniqueCharWords(words);

        System.out.println("Слова, які складаються тільки з різних символів:");
        System.out.println(Arrays.toString(result));
    }
}
