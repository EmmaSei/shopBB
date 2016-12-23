/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.shop.dto;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Эмма
 */
public class ProductTest {
    
    public ProductTest() {
    }
   
    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void testGetId() {
        Product instance = new Product(System.currentTimeMillis(), "rolex daytona gold", 300000, 1);
        System.out.println(instance.toString());
        assertNotNull(instance);
    }
    
}
