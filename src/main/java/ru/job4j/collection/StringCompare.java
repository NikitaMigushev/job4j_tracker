package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftStringCount = 0;
        int rightStringCount = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            int charCompareResult = Character.compare(left.charAt(i), right.charAt(i));
            if (charCompareResult > 0) {
                leftStringCount += Math.abs(charCompareResult);
            }
            if (charCompareResult < 0) {
                rightStringCount += Math.abs(charCompareResult);
            }
        }
        if (left.length() > right.length()) {
            for (int i = minLength - 1; i < left.length(); i++) {
                leftStringCount += (int) left.charAt(i);
            }
        }
        if (right.length() > left.length()) {
            for (int i = minLength - 1; i < right.length(); i++) {
                rightStringCount += (int) right.charAt(i);
            }
        }
        return Integer.compare(leftStringCount, rightStringCount);
    }
}
