package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEncryptor {

    public static void encrypt(String input, String output, char key) {
        int k = (int) key;

        try (
                FileInputStream fis = new FileInputStream(input);
                CipherFilterOutputStream cos = new CipherFilterOutputStream(new FileOutputStream(output), k)
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                cos.write(b);
            }
            System.out.println("Файл зашифровано → " + output);

        } catch (IOException e) {
            System.out.println("Помилка шифрування: " + e.getMessage());
        }
    }

    public static void decrypt(String input, String output, char key) {
        int k = (int) key;

        try (
                CipherFilterInputStream cis = new CipherFilterInputStream(new FileInputStream(input), k);
                FileOutputStream fos = new FileOutputStream(output)
        ) {
            int b;
            while ((b = cis.read()) != -1) {
                fos.write(b);
            }
            System.out.println("Файл розшифровано → " + output);

        } catch (IOException e) {
            System.out.println("Помилка дешифрування: " + e.getMessage());
        }
    }
}
