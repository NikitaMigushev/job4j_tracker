package ru.job4j.tracker;

public final class Lof4File {
    private static Lof4File instance = null;
    private String[] messages = new String[1000];
    private int index = 0;

    private Lof4File() {

    }

    public static Lof4File getInstance() {
        if (instance == null) {
            instance = new Lof4File();
        }
        return instance;
    }

    public void add(String message) {
        messages[index++] = message;
    }

    public void save() {
    }
}
