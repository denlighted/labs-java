package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaxWordsLine {

    private int maxWords = 0;   // збережемо кількість слів

    public String getMaxWordsLine() {
        return maxWordsLine;
    }

    public int getMaxWords() {
        return maxWords;
    }

    private String maxWordsLine = "";

    public String findMaxWordsLine(String filePath) {
        maxWords = 0;
        maxWordsLine = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;

                int count = trimmed.split("\\s+").length;

                if (count > maxWords) {
                    maxWords = count;
                    maxWordsLine = line;
                }
            }

        } catch (IOException e) {
            return "Помилка читання файлу: " + e.getMessage();
        }

        return maxWordsLine;
    }
}
