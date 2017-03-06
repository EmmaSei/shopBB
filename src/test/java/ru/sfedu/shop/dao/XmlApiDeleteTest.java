package ru.sfedu.shop.dao;

import java.util.List;
import static org.apache.log4j.LogMF.log;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
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
import ru.sfedu.shop.model.ValueOfResult;

public class XmlApiDeleteTest {
    public static final Logger log = Logger.getLogger(XmlApiDeleteTest.class);
    public XmlApiDeleteTest() {
    }
    
    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("Delete Payment");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.PAY).getValue();
            Payment payment = (Payment) result.get(0);
            res = instance.delete(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectPayment();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }    
    
    @Test
    public void testDeleteProduct() throws Exception {
        System.out.println("Delete Product");
        Result res = new Result();
        res.setStatus(StatusType.ERROR.toString());
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.PRD).getValue();
            Product product = (Product) result.get(0);
            log.info(product);
            res = instance.delete(product);
            log.debug(res.getStatus()+"errederd");
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectProduct();
        } catch (Exception e) {
            log.error("ERROR: "+e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }   
    @Test
    public void testDeleteDelivery() throws Exception {
        System.out.println("Delete Delivery");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.DLV).getValue();
            Delivery delivery = (Delivery) result.get(0);
            res = instance.delete(delivery);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectProduct();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }   
    @Test
    public void testDeleteCustomer() throws Exception {
        System.out.println("Delete Customer");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.CUS).getValue();
            Customer customer = (Customer) result.get(0);
            res = instance.delete(customer);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectCustomer();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }   
    @Test
    public void testDeleteOrder() throws Exception {
        System.out.println("Delete Order");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.ORD).getValue();
            Order order = (Order) result.get(0);
            res = instance.delete(order);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectOrder();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }    
}
