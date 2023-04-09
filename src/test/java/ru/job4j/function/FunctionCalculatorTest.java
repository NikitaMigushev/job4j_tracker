package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 12, x -> 5 * Math.pow(x, 2) + 10 * x + 15);
        List<Double> expected = Arrays.asList(30D, 55D, 90D, 135D, 190D, 255D, 330D, 415D, 510D, 615D, 730D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(8, 11, x -> Math.pow(4, x));
        List<Double> expected = Arrays.asList(65536D, 262144D, 1048576D);
        assertThat(result).containsAll(expected);
    }
}