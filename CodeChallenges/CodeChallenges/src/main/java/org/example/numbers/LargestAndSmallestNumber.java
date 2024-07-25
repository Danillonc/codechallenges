package org.example.numbers;

import java.util.Arrays;

public class LargestAndSmallestNumber {

    public static void main(String[] args) {
        int number[] = {100, 20, -5, 3000, -50, 10, 1};

        int largest = number[0];
        int smallest = number[0];

        for(int i = 0; i < number.length; i++){
            if(number[i] > largest) {
                largest = number[i];
            }else if(number[i] < smallest){
                smallest = number[i];
            }
        }

        System.out.println("Array: "+ Arrays.toString(number));
        System.out.println("Largest number: "+ largest);
        System.out.println("Smallest number: "+ smallest);

    }
}
