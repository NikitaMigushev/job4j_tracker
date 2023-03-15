package ru.job4j.typecast;

public class Airplane implements Vehicle {
    @Override
    public void start() {
        System.out.println(getClass().getSimpleName() + " Старт двигателья самолета.");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Движение самолета по воздуху.");
    }
}
