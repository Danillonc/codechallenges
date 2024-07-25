package org.example.array.tree;

import java.util.ArrayList;
import java.util.List;

public class ArrayTree {

    //Have the function ArrayChallenge(strArr) take the array of strings stored in strArr,
    // which will represent a binary tree with integer values in a format similar to how a binary
    // heap is implemented with NULL nodes at any level represented with a #.
    // Your goal is to return the pre-order traversal of the tree with the elements separated by a space.
    // For example: if strArr is ["5", "2", "6", "1", "9", "#", "8", "#", "#", "#", "#", "4", "#"]

    public static String ArrayChallenge(String[] strArr) {
        // Convert the array of strings to a list of integers
        List<Integer> tree = new ArrayList<>();
        for (String str : strArr) {
            if (!str.equals("#")) {
                tree.add(Integer.parseInt(str));
            } else {
                tree.add(null);
            }
        }

        // Perform pre-order traversal and build the result string
        StringBuilder result = new StringBuilder();
        preOrderTraversal(tree, 0, result);
        return result.toString().trim();
    }

    // Recursive method to perform pre-order traversal
    private static void preOrderTraversal(List<Integer> tree, int index, StringBuilder result) {
        if (index >= tree.size() || tree.get(index) == null) {
            return;
        }

        // Append current node value to the result
        result.append(tree.get(index)).append(" ");

        // Recursively traverse left and right subtrees
        preOrderTraversal(tree, 2 * index + 1, result); // Left child
        preOrderTraversal(tree, 2 * index + 2, result); // Right child
    }

    public static void main(String[] args) {
        // Test case
        String[] strArr = {"5", "2", "6", "1", "9", "#", "8", "#", "#", "#", "#", "4", "#"};
        System.out.println(ArrayChallenge(strArr)); // Output: 5 2 1 9 4 6 8
    }

}
