package ru.sfedu.shop.dto;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeliveryTest {
    
    public DeliveryTest() {
    }
    
    @Test
    public void testConstr() throws InterruptedException {
        Delivery instance = new Delivery(System.currentTimeMillis(), "самовывоз", 450);
        System.out.println(instance.toString());
        assertNotNull(instance);
    }
}
