package ru.job4j.oop;

public class BirdMain {
    public static void main(String[] args) {
        Bird parrot = new Bird() {
            public void flyInside() {
                System.out.println("Попугай летает только внутри анонимного класса");
            }

            @Override
            public void fly() {
                flyInside();
            }
        };
        parrot.fly();
    }
}
