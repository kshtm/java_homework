package com.epam.java.task1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyMathClassTest {

    @Disabled
    @ParameterizedTest
    @CsvSource({"1,2,2", "3,2,6"})
    void multiply(double firstArgument, double secondArgument, double result) {
        assertThat(MyMathClass.multiply(firstArgument, secondArgument),is(result));
    }

    @ParameterizedTest
    @CsvSource({"2,2,1", "6,2,3"})
    void divide(double firstArgument, double secondArgument, double result) {
        assertThat(MyMathClass.divide(firstArgument, secondArgument),is(result));
    }

    @ParameterizedTest
    @CsvSource({"0,1", "5,120"})
    void factorial(int firstArgument, int result) {
        assertThat(MyMathClass.factorial(firstArgument),is(result));
    }

    @ParameterizedTest
    @CsvSource({"2,2,1", "6,3,2"})
    void divide(double firstArgument, double secondArgument) {
        if (secondArgument == 0) {assertThrows(ArithmeticException.class, () -> divide(firstArgument, secondArgument));}
    }



}