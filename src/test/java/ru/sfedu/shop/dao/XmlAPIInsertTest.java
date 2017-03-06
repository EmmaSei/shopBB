package ru.sfedu.shop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.sfedu.shop.Main;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.dto.Customer;
import ru.sfedu.shop.dto.Delivery;
import ru.sfedu.shop.dto.Order;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.dto.Product;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;


public class XmlAPIInsertTest {
    private static final Logger log = Logger.getLogger(Main.class);
      /**
     * Test of insert method, of class XmlAPI.
     */
    // TODO Сделать тесты на insert XML для всех Bean'ов
    @Test
    public void testInsertPayment() throws Exception {
        try {
            System.out.println("Insert Payment");
            XmlApi instance = new XmlApi();
            Result result;
            ArrayList<BaseDto> list = new ArrayList<>();
            for(int i=0; i<8; i++){
                list.add(new Payment(System.currentTimeMillis(), "card", 19122016+i, (2+i)*i));
            }
            result = instance.insert(list);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    @Test
    public void testInsertProduct() throws Exception {
        try {
            System.out.println("Insert Product");
            XmlApi instance = new XmlApi();
            Result result;
            ArrayList<BaseDto> list = new ArrayList<>();
            for(int i=0; i<8; i++){
                list.add(new Product(System.currentTimeMillis(), "watch", 13000+i*1000, (2+i)*i));
            }
            result = instance.insert(list);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    @Test
    public void testInsertDelivery() throws Exception {
        try {
            System.out.println("Insert Delivery");
            XmlApi instance = new XmlApi();
            Result result;
            ArrayList<BaseDto> list = new ArrayList<>();
            for(int i=0; i<8; i++){
                list.add(new Delivery(System.currentTimeMillis(), "курьер", 100+i*5));
            }
            result = instance.insert(list);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testInsertCustomer() throws Exception {
        try {
            System.out.println("Insert Customer");
            XmlApi instance = new XmlApi();
            Result result;
            ArrayList<BaseDto> list = new ArrayList<>();
            for(int i=0; i<8; i++){
                list.add(new Customer(System.currentTimeMillis(), "Emma", "Lenina 120","7654323456","emm@sfedu.ru", false));
            }
            result = instance.insert(list);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    @Test
    public void testInsertOrder() throws Exception {
        try {
            System.out.println("Insert Order");
            XmlApi instance = new XmlApi();
            Result result;
            Customer cus =(Customer) instance.select(ClassType.CUS).getValue().get(0);;
            Delivery del = (Delivery) instance.select(ClassType.DLV).getValue().get(0);;
            Payment pay = (Payment) instance.select(ClassType.PAY).getValue().get(0);;
            HashMap<Long, Integer> products = new HashMap<>();
            Product pr1 = new Product(System.currentTimeMillis(), "watch", 10000, 2);
            Product pr2 = new Product(System.currentTimeMillis(), "watch1123", 5000, 9);
            products.put(pr1.getId(),1);
            products.put(pr2.getId(),1);
            ArrayList<BaseDto> list = new ArrayList<>();
            for(int i=0; i<8; i++){
                Order ord = new Order(System.currentTimeMillis(), "N654D5",cus.getId(),12122016L,"доставлено", pay.getId(),5, del.getId());
                ord.setProducts(products);
                list.add(ord);
            
            }
            result = instance.insert(list);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
}
