package ru.job4j.typecast;

public class Bus implements Vehicle {
    @Override
    public void start() {
        System.out.println(getClass().getSimpleName() + " Старт двигателя автобуса.");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Движение автобуса по дороге.");
    }

}
