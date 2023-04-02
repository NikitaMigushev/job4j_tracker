package ru.job4j.hmap;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        Pupil pupil = new Pupil("Nikita", new ArrayList<Subject>());
        System.out.println(pupil);
        pupil.subjects().add(new Subject("Math", 0));
        System.out.println(pupil);
        System.out.println(pupil.name());
      pupil.toString();
    }
}
