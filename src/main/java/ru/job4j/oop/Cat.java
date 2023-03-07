package ru.job4j.oop;

public class Cat {
    public String sound() {
        String voice = "may-may";
        return voice;
    }

    private String food;

    public void show() {
        System.out.println(this.name + " ate " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There is gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There is black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
