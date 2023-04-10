package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> compareByName = p -> p.getName().contains(key);
        Predicate<Person> compareBySurname = p -> p.getSurname().contains(key);
        Predicate<Person> compareByAddress = p -> p.getSurname().contains(key);
        Predicate<Person> compareByPhone = p -> p.getPhone().contains(key);
        for (Person person : persons) {
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
