package ru.job4j.typecast;

public class Train implements Vehicle {
    @Override
    public void start() {
        System.out.println(getClass().getSimpleName() + " Старт двигателя поезда.");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Движение поезда по рельсам.");
    }
}
