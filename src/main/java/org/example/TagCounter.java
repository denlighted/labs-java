package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagCounter {
    public static String readHTML(String urlString) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URI(urlString).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        return result.toString();
    }

    public static Map<String, Integer> countTags(String html) {
        Map<String, Integer> tagFrequency = new HashMap<>();
        Pattern pattern = Pattern.compile("<(\\w+)");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            String tag = matcher.group(1);
            tagFrequency.put(tag, tagFrequency.getOrDefault(tag, 0) + 1);
        }
        return tagFrequency;
    }

    public static void printSortedByLexicographicOrder(Map<String, Integer> tagFrequency) {
        List<String> sortedTags = new ArrayList<>(tagFrequency.keySet());
        Collections.sort(sortedTags);

        for (String tag : sortedTags) {
            System.out.println(tag + ": " + tagFrequency.get(tag));
        }
    }

    public static void printSortedByFrequency(Map<String, Integer> tagFrequency) {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(tagFrequency.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}