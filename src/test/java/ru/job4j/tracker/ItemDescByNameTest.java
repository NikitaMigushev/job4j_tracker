package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenDescByName() {
        List<Item> items = Arrays.asList(
                new Item("X"),
                new Item("Y"),
                new Item("Z")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("Z"),
                new Item("Y"),
                new Item("X"));
        assertThat(items.get(0).getName()).isEqualTo(expected.get(0).getName());
        assertThat(items.get(1).getName()).isEqualTo(expected.get(1).getName());
        assertThat(items.get(2).getName()).isEqualTo(expected.get(2).getName());
    }
}