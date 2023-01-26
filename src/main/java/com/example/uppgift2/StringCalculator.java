package com.example.uppgift2;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        if (numbers.startsWith("//")) {
            final var delimiter = numbers.substring(4);
            int[] multipleNumbers = Arrays.stream(numbers.substring(4)
                    .split(",|\\n|" + delimiter))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return Arrays.stream(multipleNumbers).sum();
        }
        else {
            int[] multipleNumbers = Arrays.stream(numbers.split(",|\\n"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return Arrays.stream(multipleNumbers).sum();
        }
    }

}
