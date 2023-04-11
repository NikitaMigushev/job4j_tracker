package ru.job4j.stream;

import java.util.List;

public class DropWhileEx {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 1, 2).stream()
                .dropWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .takeWhile(st -> st != null)
                .forEach(System.out::println);
    }
}
