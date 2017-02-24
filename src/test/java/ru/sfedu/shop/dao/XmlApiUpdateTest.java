package ru.sfedu.shop.dao;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;

public class XmlApiUpdateTest {
    
    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("Update Payment");
        Result res = null;
        try {
            XmlApi instance = new XmlApi();
            List<BaseDto> result;
            result = instance.select(ClassType.PAY).getValue();
            Payment payment = (Payment) result.get(4);
            payment.setAmountReceived(10000.1f);
            res = instance.update(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectPayment();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.GOOD.toString());
    }    
}
