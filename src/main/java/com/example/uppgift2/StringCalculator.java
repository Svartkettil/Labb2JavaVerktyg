package com.example.uppgift2;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        int[] multipleNumbers = Arrays.stream(numbers.split(",|\\n")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(multipleNumbers).sum();
    }

}
