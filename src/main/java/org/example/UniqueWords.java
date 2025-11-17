package org.example;

import java.util.Arrays;

public class UniqueWords {

    public static String[] findUniqueCharWords(String[] words) {
        return Arrays.stream(words)
                .filter(w -> w != null && !w.isEmpty())
                .filter(w -> w.codePoints().distinct().count() == w.codePointCount(0, w.length()))
                .toArray(String[]::new);
    }
}
