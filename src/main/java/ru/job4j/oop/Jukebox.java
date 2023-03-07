package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        }
        if (position == 2) {
            System.out.println("Спокойно ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }
}
