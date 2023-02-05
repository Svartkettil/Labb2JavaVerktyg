package com.example.uppgift2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    static String delimiter = ",|\\n";

    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        else if (numbers.startsWith("//"))
            return extractDelimimimimimiter(numbers);
        else
            return getSumFromString(numbers);
    }

    private int extractDelimimimimimiter(String numbers) {
        numbers = numbers.substring(2);
        var numbersArray = numbers.split("\n", 2);
        delimiter = delimiter + "|" + numbersArray[0].replace("[", "(")
                .replace("]", ")")
                .replace("*", "\\*")
                .replace(")(", ")|(");
        return getSumFromString(numbersArray[1]);
    }

    private int getSumFromString(String numbers) {
        int[] multipleNumbers = Arrays.stream(numbers
                        .split(delimiter))
                .mapToInt(Integer::parseInt)
                .filter((i) -> i < 1000)
                .toArray();
        checkIfNegative(multipleNumbers);
        return Arrays.stream(multipleNumbers).sum();
    }

    public void checkIfNegative(int[] numbers) {
        List<Integer> negatives = new ArrayList<>();
        for (int number : numbers) {
            if (number < 0)
                negatives.add(number);
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
    }
}
