package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        Assert.assertEquals(items, expected);
    }
}