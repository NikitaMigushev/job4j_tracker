package ru.job4j.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void whenDistance12To34Then2dot82842() {
        Point a = new Point(1, 2);
        Point b = new Point(3, 4);
        double result = a.distance(b);
        double expected = 2.82842;
        Assert.assertEquals(expected, result, 0.00001);
    }

    @Test
    void whenDistance11To11Then0() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        double result = a.distance(b);
        double expected = 0;
        Assert.assertEquals(expected, result, 0.00001);
    }

    @Test
    void whenDistance123To456Then5dot19615() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(4, 5, 6);
        double result = a.distance3d(b);
        double expected = 5.196152;
        Assert.assertEquals(expected, result, 0.00001);
    }

    @Test
    void whenDistance111To111Then0() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(1, 1, 1);
        double result = a.distance3d(b);
        double expected = 0;
        Assert.assertEquals(expected, result, 0.00001);
    }
}