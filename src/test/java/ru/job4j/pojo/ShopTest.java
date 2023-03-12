package ru.job4j.pojo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void whenIndexOfNull3() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = Shop.indexOfNull(products);
        int expected = 3;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenIndexOfNullMinus1() {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = Shop.indexOfNull(products);
        int expected = -1;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenIndexOfNull1() {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[2] = new Product("Egg", 19);
        int result = Shop.indexOfNull(products);
        int expected = 1;
        Assertions.assertThat(result).isEqualTo(expected);
    }
}