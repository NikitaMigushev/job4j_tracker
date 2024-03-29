package ru.job4j.stream;

import java.util.Comparator;

public class ProfileAscByAddress implements Comparator<Address> {

    @Override
    public int compare(Address left, Address right) {
        return left.getCity().compareTo(right.getCity());
    }
}
