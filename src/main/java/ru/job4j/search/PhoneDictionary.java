package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var result = new ArrayList<Person>();
        Predicate<Person> compareByName = p -> p.getName().contains(key);
        Predicate<Person> compareBySurname = p -> p.getSurname().contains(key);
        Predicate<Person> compareByAddress = p -> p.getSurname().contains(key);
        Predicate<Person> compareByPhone = p -> p.getPhone().contains(key);
        for (var person : persons) {
            if (compareByName
                    .or(compareBySurname)
                    .or(compareByAddress)
                    .or(compareByPhone)
                    .test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
