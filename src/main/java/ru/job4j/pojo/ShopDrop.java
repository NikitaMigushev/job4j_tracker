package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if (i > index) {
                int prev = i - 1;
                products[prev] = products[i];
            }
            if (i == products.length - 1) {
                products[i] = null;
            }
        }
        return products;
    }
}
