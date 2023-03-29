package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("migushev@gmail.com", "Nikita Migushev");
        map.put("migushev@yandex.com", "Nikita Migushev");
        map.put("migushev@yandex.com", "Nikita Migushev");
        map.put("migushev@yandex.com", "Ivan Ivan");
        map.put("migushev@mail.ru", "Ivan Ivan");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
