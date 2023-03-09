package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        int resultSum = sum(10);
        int resultMinus = minus(10);
        Calculator calculator = new Calculator();
        int resultMultiply = calculator.multiply(5);
        int resultDivide = calculator.divide(5);
        int resultSumAllOperation = calculator.sumAllOperation(5);
        System.out.println(resultSum);
        System.out.println(resultMinus);
        System.out.println(resultMultiply);
        System.out.println(resultDivide);
        System.out.println(resultSumAllOperation);
    }
}
