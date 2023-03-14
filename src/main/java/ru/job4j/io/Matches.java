package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 3 || matches > count || matches <= 0) {
                System.out.println("Можно забрать 1-3 спички или на столе слишком мало спичек. \n" +
                        "На столе лежит " + count + " спичек, так сколько же вы возьмете в этот раз?>");
            } else {
                turn = !turn;
                count -= matches;
                System.out.println("Замечательно. Осталось " + count + " спичек.");
            }
        }
        if (!turn) {
            System.out.println("Выигрыл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
