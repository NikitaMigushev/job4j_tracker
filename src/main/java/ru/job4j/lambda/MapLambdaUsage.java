package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");

        map.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));
        BiFunction<Integer, String, String> function = (key, value) -> value + "_" + key;
        map.replaceAll(function);
        System.out.println("===Check replace all");
        map.forEach((k, v) -> System.out.println(v));

        BiFunction<Integer, String, String> functionForComputeIfPresent = (k, v) -> "This is compute if present at work " + v;
        map.computeIfPresent(1, functionForComputeIfPresent);
        System.out.println("===Check computeIfPresent");
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        Function<Integer, String> functionForComputeIfAbsent = v -> String.valueOf(v * v);
        map.computeIfAbsent(10, functionForComputeIfAbsent);
        System.out.println("===Check computeIfAbsent===");
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("Shoes", 200);
        BiFunction<Integer, Integer, Integer> functionForMerge = (oldValue, newValue) -> oldValue - newValue;
        int newPrice = newMap.merge("Shoes", 50, functionForMerge);
        int nextPrice = newMap.merge("Tshirt", 50, functionForMerge);
        System.out.println("===Checking merge===");
        System.out.println("New price: " + newPrice);
        newMap.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));
    }
}
