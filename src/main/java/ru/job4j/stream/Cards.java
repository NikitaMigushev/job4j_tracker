package ru.job4j.stream;

import java.util.stream.Stream;

public class Cards {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(card -> Stream.of(Value.values())
                        .map(value -> new Card(card, value)))
                .forEach(System.out::println);
    }
}
