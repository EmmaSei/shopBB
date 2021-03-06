package ru.sfedu.shop.dto;

import java.util.Iterator;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {
    
    public OrderTest() {
    }
    
    @Test
    public void testConstr() throws InterruptedException {
        Payment payment = new Payment(System.currentTimeMillis(), "наличные", 13122016, 2);
        Customer customer = new Customer(System.currentTimeMillis(), "Igor", "Lenina 30", "9094567377", "e@mail.ru", false);
        Delivery delivery = new Delivery(System.currentTimeMillis(),"почта России",350);
        Order instance = new Order(System.currentTimeMillis(),"11A32B", customer.getId(), 07122016, "доставлен", payment.getId(), 5,delivery.getId());
        Product product = new Product(System.currentTimeMillis(),"Table", 240.45f, 3);
        Product product1 = new Product(System.currentTimeMillis(),"Desk", 1240.45f, 1);
        instance.getProducts().put(product.getId(), 1);
        instance.getProducts().put(product1.getId(),1);
        Iterator<Map.Entry <Long, Integer>> itr = instance.getProducts().entrySet().iterator();
        while (itr.hasNext())
        System.out.println(itr.next());
        System.out.println(instance.toString());
        assertNotNull(instance);
    }   
}
