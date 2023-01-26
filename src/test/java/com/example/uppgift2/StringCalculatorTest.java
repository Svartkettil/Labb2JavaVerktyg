package com.example.uppgift2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void addingZeroInputResultsInZeroOutput() {
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }
    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "10"})
    void addingOneNumberResultsInTheSameNumber(String testString){
        assertThat(stringCalculator.add(testString)).isEqualTo(Integer.parseInt(testString));

    }

}