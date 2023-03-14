package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;
    private float fuelPrice = 5.98f;

    @Override
    public void go() {
        System.out.println("Go!");
    }

    @Override
    public void passengers(int number) {
        this.passengers = number;
        System.out.println(number + " passengers have gotten into the bus.");
    }

    @Override
    public float fill(float quantity) {
        return fuelPrice * quantity;
    }
}
