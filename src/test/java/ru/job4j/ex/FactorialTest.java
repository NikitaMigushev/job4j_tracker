package ru.job4j.ex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void whenGetFactorial20Then3628800() {
        int num = 10;
        int result = 1;
        try {
            result = Factorial.getFactorial(num);
        } catch (FactorialException ex) {
            System.out.println(ex.getStackTrace());
        }
        int expected = 3628800;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenException() {
        int n = -1;
        FactorialException exception = assertThrows(
                FactorialException.class,
                () -> {
                    Factorial.getFactorial(n);
                }
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo("The number is less than 1");
    }
}