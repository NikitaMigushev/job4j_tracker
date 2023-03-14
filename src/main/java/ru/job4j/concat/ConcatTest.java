package ru.job4j.concat;

public class ConcatTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = String.join(" ", "abc", "def", "ghi");
        System.out.println(str);
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
    }
}
