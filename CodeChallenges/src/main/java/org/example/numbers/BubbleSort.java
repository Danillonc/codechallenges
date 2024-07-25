package org.example.numbers;

import java.util.Arrays;

public class BubbleSort {

    int[] sort(int[] arr){
        int size = arr.length;

        for (int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 9, 6, 4, 15, 21};
        BubbleSort bubbleSort = new BubbleSort();
        Arrays.stream(bubbleSort.sort(arr)).forEach(
                System.out::println
        );
    }
}
