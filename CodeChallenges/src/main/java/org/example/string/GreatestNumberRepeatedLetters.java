package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class GreatestNumberRepeatedLetters {

    //Have the function StringChallenge(str) take the str parameter being passed and return the first word with the greatest number of repeated letters.
    // For example: "Today, is the greatest day ever!" should return greatest because
    // it has 2 e's (and 2 t's) and it comes before ever which also has 2 e's.
    // If there are no words with repeating letters return -1.
    // Words will be separated by spaces.

    public static String stringChallenge(String str) {

        String[] words = str.split(" ");
        String result = "";
        int maxCount = 0;

        for (String word : words) {
            Map<Character, Integer> charCounts = new HashMap<>();
            int count = 0;

            for (char c : word.toCharArray()) {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
                count = Math.max(count, charCounts.get(c));
            }

            if (count > 1 && count >= maxCount) {
                if (count > maxCount || word.compareTo(result) < 0) {
                    maxCount = count;
                    result = word;
                }
            }
        }

        return result.isEmpty() ? "-1" : result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(stringChallenge("Today, is the greatest day ever!")); // Output: greatest
        System.out.println(stringChallenge("No repeated letters here.")); // Output: -1
    }


}
