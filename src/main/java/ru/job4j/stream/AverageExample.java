package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageExample {
    public static void main(String[] args) {
        List<Person> peoole = Arrays.asList(
                new Person("Мизаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        OptionalDouble average = peoole.stream()
                .mapToInt(Person::getAge)
                .average();
        double avg = average.getAsDouble();
        System.out.println(avg);
    }
}
