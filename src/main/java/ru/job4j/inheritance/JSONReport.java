package ru.job4j.inheritance;

public class JSONReport {
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        return "{" + ln
                + "\t\"name\" : \"" + name + "\"," + ln
                + "\t\"body\" : \"" + body + "\"" + ln
                + "}";
    }
}


