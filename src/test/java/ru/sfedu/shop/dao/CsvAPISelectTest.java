package ru.sfedu.shop.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ru.sfedu.shop.Main;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.model.StatusType;
import ru.sfedu.shop.model.ValueOfResult;


public class CsvAPISelectTest {
    private static Logger log = Logger.getLogger(Main.class);
     /**
     * Test of select method, of class CsvAPI.
      * @throws java.lang.Exception
     */
    @Test
    public void testSelectDelivery() throws Exception {
        System.out.println("Select Delivery");
        CsvAPI instance = new CsvAPI();
        List<BaseDto> result;
        result = instance.select(ClassType.DLV).getValue();
        //Iterator<BaseDto> it = result.iterator();
        for (int i=0; i<result.size();i++){//Iterator<BaseDto> iterator = result.iterator(); iterator.hasNext();) {
            log.trace(result.get(i));
            assertNotNull(result);
            
        }
    }
    @Test
    public void testSelectProduct() throws Exception {
        System.out.println("Select Product");
        CsvAPI instance = new CsvAPI();
        List<BaseDto> result;
        result = instance.select(ClassType.PRD).getValue();
        //System.out.println(result.size());
         for (int i=0; i<result.size();i++){//Iterator<BaseDto> iterator = result.iterator(); iterator.hasNext();) {
            log.trace(result.get(i));
            assertNotNull(result);
            
        }
    }
    @Test
    public void testSelectCustomer() throws Exception {
        System.out.println("Select Customer");
        CsvAPI instance = new CsvAPI();
        List<BaseDto> result;
        result = instance.select(ClassType.CUS).getValue();
         for (int i=0; i<result.size();i++){//Iterator<BaseDto> iterator = result.iterator(); iterator.hasNext();) {
            log.trace(result.get(i));
            assertNotNull(result);
            
        }
    }
    @Test
    public void testSelectPayment() throws Exception {
        System.out.println("Select Payment");
        CsvAPI instance = new CsvAPI();
        List<BaseDto> result;
        result = instance.select(ClassType.PAY).getValue();
         for (int i=0; i<result.size();i++){//Iterator<BaseDto> iterator = result.iterator(); iterator.hasNext();) {
            log.trace(result.get(i));
            assertNotNull(result);
            
        }
    }
     @Test
    public void testSelectOrder() throws Exception {
        System.out.println("Select Order");
        CsvAPI instance = new CsvAPI();
        List<BaseDto> result;
        result = instance.select(ClassType.ORD).getValue();
        for (int i=0; i<result.size();i++){//Iterator<BaseDto> iterator = result.iterator(); iterator.hasNext();) {
            log.trace(result.get(i));
            assertNotNull(result);
            
        }
    }
}
