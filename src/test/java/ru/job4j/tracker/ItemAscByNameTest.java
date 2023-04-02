package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ItemAscByNameTest {
    @Test
    public void whenAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Z"),
                new Item("Y"),
                new Item("X")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("X"),
                new Item("Y"),
                new Item("Z"));
        Assert.assertEquals(items, expected);
    }
}