package com.example.uppgift2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @CsvSource({"'1,0', 1", "'1,2', 3", "'10,2', 12"})
    void addingTwoNumbersShouldBeSeparatedByCommaAndSummarizeTheNumbers(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
    @ParameterizedTest(name = "{index} => ''{0}'' is {1}")
    @CsvSource({"'1,0,1', 2", "'1,2,3,4', 10", "'10,3,4,1,5', 23"})
    void addingMoreThanTwoNumbersShouldBeSeparatedByCommaAndSummarizeTheNumbers(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource({"'0\n1', 1", "'2\n1,3', 6"})
    void usingLineBreaksAlsoWorksAsSeparators(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
    @ParameterizedTest(name = "{index} => ''{0}'' is {1}")
    @CsvSource({"'//;\n1;3', 4", "'//r\n3,2r1', 6"})
    void usingTwoDashesMakesNextCharacterWorkAsASeparator(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource({"'1,-3', '[-3]'", "'//p\n-3,-4p2', '[-3, -4]'", "'1,1,2,-1,-1,-1', '[-1, -1, -1]'" })
    void addingNegativeNumbersThrowsAnException(String testString, String expected){
        assertThatThrownBy(()->stringCalculator.add(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("negatives not allowed: " + expected);
    }
    @ParameterizedTest
    @CsvSource({"'1000','0'", "'999,5000', '999'", "'999,2,1', 1002"})
    void numbersOverThousandShouldBeIgnored(String testString, int expected){
        assertThat(stringCalculator.add(testString)).isEqualTo(expected);
    }
}