package ru.sfedu.shop.dto;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    
    public CustomerTest() {
    }
    @Test
    public void testConstructor() throws InterruptedException {
        Customer instance ;
        instance = new Customer(System.currentTimeMillis(), "Ivan", "Зорге 21 Ж", "89081981998", "s_emm_g@mail.ru",false);
        System.out.println(instance.toString());
        assertNotNull(instance);
    }

}
