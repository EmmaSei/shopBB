package ru.sfedu.shop.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.dto.Customer;
import ru.sfedu.shop.dto.Delivery;
import ru.sfedu.shop.dto.Order;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.dto.Product;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;


public class CsvAPIDeleteTest {
     /**
     * Test of Delete method, of class CsvAPI.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteProduct() throws Exception {
        System.out.println("Delete Product");
        CsvAPI instance = new CsvAPI();
        Result result = null;
        Product product = new Product(1482168292007L, "desk", 1500, 3);
        instance.insert(product);
        result=instance.delete(product);
        assertEquals(StatusType.GOOD.toString(), result.getStatus());
    }
    @Test
    public void testDeleteDelivery() throws Exception {
        System.out.println("Delete Delivery");
        CsvAPI instance = new CsvAPI();
        Result result = null;
        Delivery delivery = new Delivery(1482168292007L, "customer pickup", 1500);
        instance.insert(delivery);
        result=instance.delete(delivery);
        assertEquals(StatusType.GOOD.toString(), result.getStatus());
    }
    @Test
    public void testDeleteCustomer() throws Exception {
        System.out.println("Delete Customer");
        CsvAPI instance = new CsvAPI();
        Result result = null;
        Customer customer = new Customer(1482175625146L, "Pavel", "Zorge zh", "9876543456","pasha@mail.ru", false);
        instance.insert(customer);
        result=instance.delete(customer);
        assertEquals(StatusType.GOOD.toString(), result.getStatus());
    }
    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("Delete Payment");
        CsvAPI instance = new CsvAPI();
        Result result = null;
        Payment payment = new Payment(1482176292007L, "card", 19122016, 2);
        instance.insert(payment);
        result=instance.delete(payment);
        assertEquals(StatusType.GOOD.toString(), result.getStatus());
    }
    @Test
    public void testDeleteOrder() throws Exception {
        System.out.println("Delete Order");
        CsvAPI instance = new CsvAPI();
        Result result = null;
        Payment payment = new Payment(1482176292007L, "card", 19122016, 2);
        Order order = new Order(1482176292007L, "12A765", 4236346435343L ,19122016,"sended", payment.getId(), 3, 4567876543L);
        instance.insert(order);
        result=instance.delete(order);
        assertEquals(StatusType.GOOD.toString(), result.getStatus());
    }
}
