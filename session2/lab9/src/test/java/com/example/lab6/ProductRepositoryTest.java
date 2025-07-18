
package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository productRepository = new ProductRepository();

    @Test
    void printingInitializedProducts(){
        System.out.println(productRepository.findAll());
    }

    @Test
    void findAll() {
        int sizeOfProducts = productRepository.findAll().size();
        assertEquals(3,sizeOfProducts);
    }

    @Test
    void findById() {

        System.out.println("Product with id 1:"+ productRepository.findById(1L));
        assertEquals("Laptop", productRepository.findAll().get(0).getName());
    }

    @Test
    void save() {

        Product newProduct = new Product(1L,"Laptop maxx",1200.00);
        Product savedProduct = productRepository.save(newProduct);

        productRepository.save(newProduct);

        System.out.println("Product Repository with id 1:"+ productRepository.findById(1L));
        assertNotEquals("Laptop max", productRepository.findAll().get(0).getName());
        assertNotEquals("Laptop max", productRepository.findById(1L).get().getName());
        assertEquals("Laptop maxx", productRepository.findById(1L).get().getName());

    }
}