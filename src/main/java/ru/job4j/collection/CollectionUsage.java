package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionUsage {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        for (String str : collection) {
            System.out.println(str);
        }
        collection.remove("two");
        System.out.println("Вывод содержимого коллекции после удаления");
        for (String str : collection) {
            System.out.println(str);
        }
        System.out.println("Размер коллекции равен: " + collection.size());
        System.out.println("Коллекция содержит элемент two: " + collection.contains("two"));
        System.out.println("Содерживмое в виде массива: " + Arrays.toString(collection.toArray()));
        collection.clear();
        System.out.println("Коллеция после очистики пуста: " + collection.isEmpty());
    }
}
