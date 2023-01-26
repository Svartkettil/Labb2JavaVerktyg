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
            int[] multipleNumbers = Arrays.stream(numbers.substring(4)
                    .split(",|\\n|" + delimiter))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            checkIfNegative(multipleNumbers);
            return Arrays.stream(multipleNumbers).sum();
        }
        else {
            int[] multipleNumbers = Arrays.stream(numbers.split(",|\\n"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            checkIfNegative(multipleNumbers);
            return Arrays.stream(multipleNumbers).sum();
        }
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
