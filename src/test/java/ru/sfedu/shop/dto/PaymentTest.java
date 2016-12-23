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
public class PaymentTest {
    
    public PaymentTest() {
    }
    /**
     * Test of getId method, of class Payment.
     */
    @Test
    public void testGetId() {
        Payment instance = new Payment(System.currentTimeMillis(), "Начиными при доставке", 07122016, 5);
        System.out.println(instance.toString());
        assertNotNull(instance);
    }
    
}
