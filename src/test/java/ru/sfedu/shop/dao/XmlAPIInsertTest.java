package ru.sfedu.shop.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.sfedu.shop.Main;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.Payment;
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
    
}
