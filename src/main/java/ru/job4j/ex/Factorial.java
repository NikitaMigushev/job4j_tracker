package ru.job4j.ex;

public class Factorial {
    public static int getFactorial(int num) throws FactorialException {
        int result = 1;
        if (num < 1) {
            throw new FactorialException("The number is less than 1");
        }
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
