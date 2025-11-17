package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translator translator = new Translator();

        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("i", "я");
        translator.addWord("love", "люблю");
        translator.addWord("java", "джава");

        System.out.println("Бажаєте додати нові слова до словника? (yes/no)");
        String answer = scanner.nextLine();

        while (answer.equalsIgnoreCase("yes")) {
            System.out.print("Введіть англійське слово: ");
            String eng = scanner.nextLine();

            System.out.print("Введіть переклад українською: ");
            String ukr = scanner.nextLine();

            translator.addWord(eng, ukr);

            System.out.println("Додати ще слово? (yes/no)");
            answer = scanner.nextLine();
        }

        System.out.println("Введіть фразу англійською мовою:");
        String phrase = scanner.nextLine();

        String translated = translator.translatePhrase(phrase);
        System.out.println("Переклад: " + translated);
    }
}