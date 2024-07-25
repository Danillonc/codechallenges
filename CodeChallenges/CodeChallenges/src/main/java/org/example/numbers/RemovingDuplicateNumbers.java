package org.example.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemovingDuplicateNumbers {

    public static void main(String[] args) {
        int numberArray[] = {1,9,8,10,20,8,10,9,7,7};
        List<Integer> listArray = new ArrayList<>();
        Arrays.sort(numberArray);

        for(int i = 0; i < numberArray.length; i++){
            if(!listArray.contains(numberArray[i])){
                listArray.add(numberArray[i]);
            }
        }

        System.out.println(listArray);
    }
}
