package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class LimExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(rsl);
    }
}
