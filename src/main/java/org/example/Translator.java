package org.example;

import java.util.HashMap;
import java.util.Map;

class Translator {
    private Map<String, String> dictionary = new HashMap<>();

    public void addWord(String english, String ukrainian) {
        dictionary.put(english.toLowerCase(), ukrainian.toLowerCase());
    }

    public String translatePhrase(String phrase) {
        String[] words = phrase.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                result.append(dictionary.get(word)).append(" ");
            } else {
                result.append("[").append(word).append("]").append(" ");
            }
        }
        return result.toString().trim();
    }
}