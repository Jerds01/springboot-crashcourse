package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    public static String productName = "Milk";
    public static int productPrice = 100;

    Product product = new Product(productName, productPrice);

    @Test
    void testNullId() {
        Assertions.assertEquals(null,product.getId());
    }

    @Test
    void testProductId(){
        String productName = "Talong";
        int productPrice = 10;
        Long id = 1L;

        Product product = new Product(id, productName, productPrice);

        Assertions.assertEquals(1, product.getId());
    }

    @Test
    void testProductGetName() {
        Assertions.assertEquals("Milk",product.getName());
    }

    @Test
    void testProductGetPrice() {
        Assertions.assertEquals(100,product.getPrice());
    }

    @Test
    void testProductSetId() {
        Long id = 5L;
        product.setId(id);
        Assertions.assertEquals(5, product.getId());
    }

    @Test
    void testProductSetName() {
        Assertions.assertEquals("Milk", product.getName());
        String name = "Gatas";
        product.setName(name);
        Assertions.assertEquals("Gatas", product.getName());
        Assertions.assertNotEquals("Milk", product.getName());
    }

    @Test
    void testProductSetPrice() {
        Assertions.assertEquals(100, product.getPrice());
        double price = 99;
        product.setPrice(price);
        Assertions.assertEquals(99, product.getPrice());
        Assertions.assertNotEquals(100, product.getPrice());
    }

    @Test
    public void testBooleanEqual() {
        Product product1 = new Product((long) 3,"notMilk",101);
        Assertions.assertEquals(true,product.equals(product));
    }

    @Test
    public void testHashCode(){
        Assertions.assertEquals(product.hashCode(), Objects.hash(product.getId(),product.getName(),product.getPrice()));
    }
}