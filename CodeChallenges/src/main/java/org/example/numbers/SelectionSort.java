package org.example.numbers;

import java.util.Arrays;

public class SelectionSort {

    int[] sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n -1; i++){
            int minIndex = i;

            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 9, 6, 4, 15, 21};
        SelectionSort selection = new SelectionSort();
        Arrays.stream(selection.sort(arr)).forEach(
                System.out::println
        );
    }
}
