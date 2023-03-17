package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    void whenCalc4Then24() {
        int n = 4;
        int result = new Fact().calc(n);
        int expected = 24;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenException() {
        int n = -1;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(n);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }
}