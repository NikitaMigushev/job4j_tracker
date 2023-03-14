package ru.job4j.varargs;

public class VarArgs {
    public static String text(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder + " Количество соединенных элементов: " + strings.length;
    }

    public static String text(int x, int y, String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append(x).append(y);
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static String text(int x, String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(text());
        System.out.println(text("aaa"));
        System.out.println(text("aaa", "bbb", "ccc"));
        System.out.println(text(1, 2, "aaa", "bbb"));
    }
}
