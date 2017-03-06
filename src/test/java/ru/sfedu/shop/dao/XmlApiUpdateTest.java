package ru.sfedu.shop.dao;

import java.util.List;
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

public class XmlApiUpdateTest {
    
    @Test
    public void testUpdatePayment() throws Exception {
        System.out.println("Update Payment");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.PAY).getValue();
            Payment payment = (Payment) result.get(1);
            payment.setAmountReceived(10000.1f);
            res = instance.update(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectPayment();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }    
    
    @Test
    public void testUpdateProduct() throws Exception {
        System.out.println("Update Product");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.PRD).getValue();
            Product product = (Product) result.get(0);
            product.setCount(100);
            res = instance.update(product);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectProduct();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }    
    
    @Test
    public void testUpdateDelivery() throws Exception {
        System.out.println("Update Delivery");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.DLV).getValue();
            Delivery delivery = (Delivery) result.get(0);
            delivery.setMethod("pochta Rossii");
            res = instance.update(delivery);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectDelivery();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    } 
    
    @Test
    public void testUpdateCustomer() throws Exception {
        System.out.println("Update Customer");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.CUS).getValue();
            Customer customer = (Customer) result.get(0);
            customer.setAddress("Zorge 21 zh");
            res = instance.update(customer);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectCustomer();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }  
    
    @Test
    public void testUpdateOrder() throws Exception {
        System.out.println("Update Order");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.ORD).getValue();
            Order order = (Order) result.get(0);
            result = instance.select(ClassType.CUS).getValue();
            Customer customer = (Customer) result.get(0);
            order.setCustomer(customer.getId());
            res = instance.update(order);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectOrder();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    } 
}
