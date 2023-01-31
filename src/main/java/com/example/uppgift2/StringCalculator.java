package com.example.uppgift2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        if (numbers.startsWith("//")) {
            final var delimiter = numbers.substring(2,3);
            return getSumFromString(numbers.substring(4), ",|\\n|" + delimiter);
        }
        else {
            return getSumFromString(numbers, ",|\\n");
        }
    }

    private int getSumFromString(String numbers, String delimiter) {
        int[] multipleNumbers = Arrays.stream(numbers
                .split(delimiter))
                .mapToInt(Integer::parseInt)
                .filter((i) -> i<1000)
                .toArray();
        checkIfNegative(multipleNumbers);
        return Arrays.stream(multipleNumbers).sum();
    }

    public void checkIfNegative(int[] numbers){
        List<Integer> negatives = new ArrayList<>();
        for (int number : numbers) {
            if (number < 0)
                negatives.add(number);
        }
        if (!negatives.isEmpty()) {
            String message = "negatives not allowed: " + negatives;
            throw new IllegalArgumentException(message);
        }
    }
}
