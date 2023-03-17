package ru.job4j.ex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountTest {
    @Test
    public void whenCount0To3Then3() {
        int start = 0;
        int finish = 3;
        int expected = 3;
        int result = Count.add(start, finish);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenException() {
        int start = 10;
        int finish = 3;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Count.add(start, finish);
                });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Start should be less than finish.");
    }
}