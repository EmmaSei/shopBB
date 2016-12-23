package ru.sfedu.shop.dao;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.shop.Client;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.Customer;
import ru.sfedu.shop.dto.Delivery;
import ru.sfedu.shop.dto.Order;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.dto.Product;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;

/**
 *
 * @author Эмма
 */
public class CsvAPIInsertTest {
     private static final Logger log = Logger.getLogger(Client.class);
       /**
     * Test of insert method, of class CsvAPI.
     */
    @Test
    public void testInsertDelivery() throws Exception {
        try {
            System.out.println("Insert Delivery");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result;
            Delivery obj;
            for (int i = 0; i < 10; i++) {
                obj = new Delivery(System.currentTimeMillis(), "customer pickup", 0);
                result = instance.insert(obj);
                assertEquals(StatusType.GOOD.toString(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    @Test
    public void testInsertProduct() throws Exception {
        try {
            System.out.println("Insert Product");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result;
            Product obj;
            for (int i = 0; i < 10; i++) {
                obj = new Product(System.currentTimeMillis(), "desk", 100 ,5);
                result = instance.insert(obj);
                assertEquals(StatusType.GOOD.toString(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }   
    @Test
    public void testInsertCustomer() throws Exception {
        try {
            System.out.println("Insert Customer");
            CsvAPI instance = new CsvAPI();
            Result result;
            Customer obj;
            for (int i = 1; i < 11; i++) {
                obj = new Customer(System.currentTimeMillis(), "Pavel", "Zorge "+i+" zh", "9876543456","pasha@mail.ru");
                result = instance.insert(obj);
                assertEquals(StatusType.GOOD.toString(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testInsertPayment() throws Exception {
        try {
            System.out.println("Insert Payment");
            CsvAPI instance = new CsvAPI();
            Result result;
            Payment obj;
            Product bj = new Product(System.currentTimeMillis(), "desk", 100 ,5);
            instance.insert(bj);
            for (int i = 0; i < 10; i++) {
                obj = new Payment(System.currentTimeMillis(), "card", 19122016, 2);
                obj.getProducts().put(bj.getId(), 5);
                result = instance.addPayment(obj);
                assertEquals(StatusType.GOOD.toString(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testInsertOrder() throws Exception {
        try {
            System.out.println("Insert Order");
            CsvAPI instance = new CsvAPI();
            Delivery delivery = new Delivery(System.currentTimeMillis(), "customer pickup", 0);
            Payment payment = new Payment(System.currentTimeMillis(), "card", 19122016, 2);
            Customer customer = new Customer(System.currentTimeMillis(), "Pavel", "Zorge zh", "9876543456","pasha@mail.ru");
            Product product = new Product(System.currentTimeMillis(), "desk", 100 ,5);
            payment.getProducts().put(product.getId(), 2);
            product = new Product(System.currentTimeMillis(), "table", 200 ,5);
            payment.getProducts().put(product.getId(), 1);
            Result result;
            Order obj;
            for (int i = 1; i < 11; i++) {
                obj = new Order(System.currentTimeMillis(), "12A765", customer.getId(),19122016,"sended", payment, 3, delivery.getId());
                result = instance.insert(obj);
                assertEquals(StatusType.GOOD.toString(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testAddPayment() throws Exception {
        try {
            System.out.println("Add Payment");
            CsvAPI instance = new CsvAPI();
            Payment payment = new Payment(System.currentTimeMillis(), "card", 19122016, 2);
            Product product = new Product(System.currentTimeMillis(), "desk", 100 ,5);
            instance.insert(product);
            payment.getProducts().put(product.getId(), 2);
            product = new Product(System.currentTimeMillis(), "table", 200 ,5);
            instance.insert(product);
            payment.getProducts().put(product.getId(), 1);
            Result result;
            
            result = instance.addPayment(payment);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e.getMessage());
            throw e;
        }
    }
}