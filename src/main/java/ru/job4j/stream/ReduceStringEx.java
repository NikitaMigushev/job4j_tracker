package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

public class ReduceStringEx {
    public static void main(String[] args) {
        List<String> nums = List.of("Один", "Два", "Три");
        Optional<String> sum = nums.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(sum.get());
    }
}
