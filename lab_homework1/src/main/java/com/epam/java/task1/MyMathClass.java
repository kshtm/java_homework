package com.epam.java.task1;

public class MyMathClass {

    static String helloWorld() {
        return "Hello world";
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }

    static int factorial(int a) {
        int factorial = 1;
        for (int i = 1; i <= a; ++i) factorial *= i;
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(divide(9, 5));
        System.out.println(multiply(9, 5));
        System.out.println(factorial(6));
    }



}
