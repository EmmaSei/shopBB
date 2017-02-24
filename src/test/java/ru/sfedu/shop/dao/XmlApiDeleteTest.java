package ru.sfedu.shop.dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static ru.sfedu.shop.dao.XmlAPISelectTest.log;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;
import ru.sfedu.shop.model.ValueOfResult;

public class XmlApiDeleteTest {
    
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
}
