package ru.job4j.inheritance;

public class HideExampleMain {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal kitty = new Kitty();
        animal.instanceInvoke();
        kitty.instanceInvoke();
        Animal.staticInvoke();
        kitty.staticInvoke();
    }
}
