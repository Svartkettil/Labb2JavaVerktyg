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
    @ParameterizedTest(name = "{index} => ''{0}'' is {1}")
    @CsvSource({"'1,0', 1", "'1,2', 3", "'10,-2', 8"})
    void addingTwoNumbersShouldBeSeparatedByCommaAndSummarizeTheNumbers(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
    @ParameterizedTest(name = "{index} => ''{0}'' is {1}")
    @CsvSource({"'1,0,1', 2", "'1,-2,3,4', 6", "'10,-3,-4,-1,-5', -3"})
    void addingMoreThanTwoNumbersShouldBeSeparatedByCommaAndSummarizeTheNumbers(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource({"'0\n1', 1", "'2\n-1,3', 4"})
    void usingLineBreaksAlsoWorksAsSeparators(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
}