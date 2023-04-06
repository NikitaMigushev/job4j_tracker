package ru.job4j.lambda;

import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return Integer.compare(left.getSize(), right.getSize());
        };
        Comparator<String> cmpSize = (left, right)
                -> Integer.compare(left.length(), right.length());
        Comparator<String> cmpText = (left, right)
                -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right)
                -> Integer.compare(right.length(), left.length());
        Comparator<String> numStr = (left, right) -> {
            int first = Integer.valueOf(left.substring(0, left.indexOf(".")));
            int second = Integer.valueOf(right.substring(0, right.indexOf(".")));
            return Integer.compare(first, second);
        };
    }
}
