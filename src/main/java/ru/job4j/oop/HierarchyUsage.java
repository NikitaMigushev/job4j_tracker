package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar();
        Transport tp = sportCar;
        Object obj = sportCar;
        Object ocar = new SportCar();
        SportCar carFromObject = (SportCar) ocar;
        Object bicycle = new Bicycle();
        SportCar cb = (SportCar) new Bicycle();
        System.out.println(new SportCar());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}
