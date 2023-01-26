package com.example.uppgift2;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        int[] multipleNumbers = Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
        if (multipleNumbers.length == 1)
            return multipleNumbers[0];
        return multipleNumbers[0] + multipleNumbers[1];
    }

}
