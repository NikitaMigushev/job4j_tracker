package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = {new Book("Clean Code", 464),
                new Book("Martin Eden", 444),
                new Book("Fire & Blood", 801),
                new Book("Thinking, Fast and Slow", 483)};

        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName());
        }
        System.out.println("Replace book 0 and 3");
        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName());
        }
        System.out.println("Show Clean Code");
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if ("Clean Code".equals(b.getName())) {
                System.out.println(b.getName());
            }
        }
    }
}
