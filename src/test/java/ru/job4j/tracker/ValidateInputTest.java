package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assertions.assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assertions.assertThat(selected).isEqualTo(0);
    }

    @Test
    void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        Assertions.assertThat(input.askInt("Enter menu:")).isEqualTo(0);
        Assertions.assertThat(input.askInt("Enter menu:")).isEqualTo(1);
        Assertions.assertThat(input.askInt("Enter menu:")).isEqualTo(2);
    }

    @Test
    void whenNegativeInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assertions.assertThat(selected).isEqualTo(-1);
    }
}