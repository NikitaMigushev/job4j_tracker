package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int compare = 0;
        int minLength = Math.min(left.length(), right.length());
        String minString = left.length() < right.length() ? left : right;
        String maxString = left.length() > right.length() ? left : right;
        if (left.length() != right.length()
                && maxString.substring(0, minString.length()).equals(minString)) {
                return Integer.compare(left.length(), right.length());
        }
        for (int i = 0; i < minLength; i++) {
            char charLeft = left.charAt(i);
            char charRight = right.charAt(i);
            if (charLeft != charRight) {
                compare += Character.compare(charLeft, charRight);
            }
        }
        return compare;
    }
}
