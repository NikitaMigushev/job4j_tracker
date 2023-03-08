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
        Calculator multiply = new Calculator();
        int resultMultiply = multiply.multiply(5);
        Calculator divide = new Calculator();
        int resultDivide = divide.divide(5);
        Calculator sumAllOperation = new Calculator();
        int resultSumAllOperation = sumAllOperation.sumAllOperation(5);
        System.out.println(resultSum);
        System.out.println(resultMinus);
        System.out.println(resultMultiply);
        System.out.println(resultDivide);
        System.out.println(resultSumAllOperation);
    }
}
