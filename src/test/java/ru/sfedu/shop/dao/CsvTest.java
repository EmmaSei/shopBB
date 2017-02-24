package ru.sfedu.shop.dao;

import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.sfedu.shop.Main;
import ru.sfedu.shop.dto.Customer;
import ru.sfedu.shop.dto.Delivery;
import ru.sfedu.shop.dto.Order;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.dto.Product;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;
import ru.sfedu.shop.model.ValueOfResult;

/**
 *
 * @author Эмма
 */
public class CsvTest {
     private static final Logger log = Logger.getLogger(CsvAPI.class);
    /**
     * Test of getOrderDetail method, of class CsvAPI.
     */
    @Test
    public void testGetOrderDetail() throws Exception{
        try {
            System.out.println("Order Detail");
            CsvAPI instance = new CsvAPI();
            Delivery delivery = new Delivery(System.currentTimeMillis(), "customer pickup", 0);
            Payment payment = new Payment(System.currentTimeMillis(), "card", 19122016, 2);
            Customer customer = new Customer(System.currentTimeMillis(), "Pavel", "Zorge zh", "9876543456","pasha@mail.ru", false);
            Order order = new Order(System.currentTimeMillis(), "B2A888", customer.getId(),19122016,"sended", payment.getId(), 3, delivery.getId());
            instance.insert(order);
            Result result = instance.getOrderDetail(order.getNumber());
            log.info(result);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testGetDeliveryByOrderNumber() throws Exception{
        try {
            System.out.println("Get Delivery By Order Number");
            CsvAPI instance = new CsvAPI();
            Delivery delivery = new Delivery(System.currentTimeMillis(), "customer pickup", 0);
            Payment payment = new Payment(System.currentTimeMillis(), "card", 19122016, 2);
            Customer customer = new Customer(System.currentTimeMillis(), "Pavel", "Zorge zh", "9876543456","pasha@mail.ru", false);
            Order order = new Order(System.currentTimeMillis(), "B2E528", customer.getId(),19122016,"sended", payment.getId(), 3, delivery.getId());
            Product product = new Product(System.currentTimeMillis(), "desk", 100 ,5);
            order.getProducts().put(product.getId(), 2);
            product = new Product(System.currentTimeMillis(), "table", 200 ,5);
            order.getProducts().put(product.getId(), 1);
            instance.insert(order);
            Result result = instance.getDeliveryByOrderNumber(order.getNumber());
            log.info(result);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
            } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testGetCustomerActivity() throws Exception{
        try {
            System.out.println("Get Customer Activity");
            CsvAPI instance = new CsvAPI();
            Delivery delivery = new Delivery(System.currentTimeMillis(), "customer pickup", 0);
            Payment payment = new Payment(System.currentTimeMillis(), "card", 19122016, 2);
            Customer customer = new Customer(System.currentTimeMillis(), "Pavel", "Zorge zh", "9876543456","pasha@mail.ru", false);
            Order order = new Order(System.currentTimeMillis(), "B24628", customer.getId(),19122016,"sended", payment.getId(), 3, delivery.getId());
            Order order1 = new Order(System.currentTimeMillis(), "B23228", customer.getId(),19122016,"sended", payment.getId(), 3, delivery.getId());
            instance.insert(order);
            instance.insert(order1);
            ValueOfResult result = instance.getCustomerActivity(customer.getId());
            log.info("Count orders: "+result.getValue().size());
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
            } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
}
