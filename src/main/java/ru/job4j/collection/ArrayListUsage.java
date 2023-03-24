package ru.job4j.collection;

import java.util.ArrayList;

public class ArrayListUsage {
    public static void main(String[] args) {
        ArrayList names = new ArrayList();
        names.add("Petr");
        names.set(0, "Ivan");
        names.remove(0);
        names.add("Ivan");
        for (int i = 0; i < names.size(); i++) {
            Object value = names.get(i);
            System.out.println(value);
        }
        for (Object value : names) {
            System.out.println(value);
        }
        ArrayList<String> namesString = new ArrayList<String>();
    }
}
