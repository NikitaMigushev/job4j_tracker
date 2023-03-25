package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<Item>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item element : items) {
            if (element.getName().equals(key)) {
                rsl.add(element);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        for (Item element : items) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = 0;
        for (Item element : items) {
            if (element.getId() == id) {
                items.set(index, item);
                item.setId(id);
                rsl = true;
                break;
            }
            index++;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = 0;
        for (Item element : items) {
            if (element.getId() == id) {
                items.remove(index);
                rsl = true;
                break;
            }
            index++;
        }
        return rsl;
    }
}