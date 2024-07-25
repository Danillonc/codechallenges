package org.example.searching;

public class Searching {

    //Have the function SearchingChallenge(str) take the str parameter being passed and return 1
    // if the brackets are correctly matched and each one is accounted for.
    // Otherwise return 0. For example: if str is "(hello (world))", then the output should be 1,
    // but if str is "((hello (world))" the the output should be 0 because the brackets do not correctly match up.
    // Only "(" and ")" will be used as brackets. If str contains no brackets return 1.


    public static int SearchingChallenge(String str) {
        // Count of open brackets
        int openBrackets = 0;

        // Iterate through each character in the string
        for (char c : str.toCharArray()) {
            if (c == '(') {
                // Increment count for open bracket
                openBrackets++;
            } else if (c == ')') {
                // If there's a closing bracket without a corresponding open bracket, return 0
                if (openBrackets == 0) {
                    return 0;
                }
                // Decrement count for open bracket
                openBrackets--;
            }
        }

        // If openBrackets is zero, all brackets are correctly matched
        // If openBrackets is non-zero, there are more open brackets than closing brackets
        return openBrackets == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(SearchingChallenge("(hello (world))")); // Output: 1
        System.out.println(SearchingChallenge("((hello (world))")); // Output: 0
        System.out.println(SearchingChallenge("hello world")); // Output: 1 (no brackets)
    }

}
