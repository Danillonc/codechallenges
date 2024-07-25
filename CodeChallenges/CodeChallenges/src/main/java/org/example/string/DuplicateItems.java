package org.example.string;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DuplicateItems {

    public static void main(String[] args) {
        // Replace "input.txt" with the path to your file
        String filePath = "/home/danillo/Downloads/FeeCellCoinAbril50.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, Integer> frequencyMap = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into individual items, assuming items are separated by spaces
                String[] items = line.split("\\s+");

                // Count the frequency of each item
                for (String item : items) {
                    // Update the frequency map
                    frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
                }
            }

            // Iterate over the frequency map to find duplicates
            for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
