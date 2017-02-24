package ru.sfedu.shop.dao;

import java.util.List;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ru.sfedu.shop.Main;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;


public class XmlAPISelectTest {
    public static final Logger log = Logger.getLogger(Main.class);
    // TODO Сделать тесты на insert XML для всех Bean'ов
    @Test
    public void testSelectPayment() throws Exception {
        System.out.println("Select Payment");
        XmlApi instance = new XmlApi();
        List<BaseDto> result;
        result = instance.select(ClassType.PAY).getValue();
         for (int i=0; i<result.size();i++){
            log.trace(i+1 + ") "+ result.get(i));
            assertNotNull(result);
            
        }
    }
    
    @Test
    public void testSelectWithParametrPayment() throws Exception {
        System.out.println("Parametred Select Payment");
        XmlApi instance = new XmlApi();
        List<BaseDto> result;
        result = instance.select(ClassType.PAY, "dateReceived", "19122019").getValue();
         for (int i=0; i<result.size();i++){
            log.trace(result.get(i));
            assertNotNull(result);
            
        }
    }
}
