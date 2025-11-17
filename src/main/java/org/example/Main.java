package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MaxWordsLine analyzer = new MaxWordsLine();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 – Рядок з максимальною кількістю слів у файлі");
            System.out.println("2 – Зашифрувати файл");
            System.out.println("3 – Дешифрувати файл");
            System.out.println("4 – Підрахунок HTML-тегів по URL");
            System.out.println("0 – Вихід");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Введіть шлях до файлу: ");
                    String path = scanner.nextLine();

                    String line = analyzer.findMaxWordsLine(path);

                    System.out.println("Рядок: " + line);
                    System.out.println("Кількість слів: " + analyzer.getMaxWords());
                    break;

                case "2":
                    System.out.print("Введіть вхідний файл: ");
                    String inEnc = scanner.nextLine();

                    System.out.print("Введіть вихідний файл: ");
                    String outEnc = scanner.nextLine();

                    System.out.print("Введіть ключ (символ): ");
                    char keyE = scanner.nextLine().charAt(0);

                    FileEncryptor.encrypt(inEnc, outEnc, keyE);
                    break;

                case "3":
                    System.out.print("Введіть вхідний файл: ");
                    String inDec = scanner.nextLine();

                    System.out.print("Введіть вихідний файл: ");
                    String outDec = scanner.nextLine();

                    System.out.print("Введіть ключ (символ): ");
                    char keyD = scanner.nextLine().charAt(0);

                    FileEncryptor.decrypt(inDec, outDec, keyD);
                    break;

                case "4":
                    try {
                        System.out.print("Введіть URL: ");
                        String url = scanner.nextLine();

                        String html = TagCounter.readHTML(url);
                        Map<String, Integer> tagFrequency = TagCounter.countTags(html);

                        System.out.println("\n--- Лексикографічний порядок ---");
                        TagCounter.printSortedByLexicographicOrder(tagFrequency);

                        System.out.println("\n--- За частотою (зменшення) ---");
                        TagCounter.printSortedByFrequency(tagFrequency);

                    } catch (Exception e) {
                        System.out.println("Помилка при отриманні сторінки: " + e.getMessage());
                    }
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Неправильна команда.");
            }
        }
    }
}
