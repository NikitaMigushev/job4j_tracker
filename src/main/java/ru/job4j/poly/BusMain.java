package ru.job4j.poly;

public class BusMain {
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.passengers(10);
        System.out.println(bus.fill(10));
        bus.go();
    }
}
