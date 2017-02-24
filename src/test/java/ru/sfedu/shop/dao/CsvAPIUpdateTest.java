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

/**
 *
 * @author Эмма
 */
public class CsvAPIUpdateTest {
    private static final Logger log = Logger.getLogger(Main.class);
     @Test
    public void testUpdateDelivery() throws Exception {
        try{
           System.out.println("Update Delivery");
            CsvAPI instance = new CsvAPI();
            Delivery del;
            Result result;
            del = new Delivery(8765432345L, "delivery", 0);
            result = instance.update(del);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    @Test
    public void testUpdateCustomer() throws Exception {
        try{
           System.out.println("Update Custemer");
            CsvAPI instance = new CsvAPI();
            Customer obj= new Customer(9876543L,"Pavel", "Zorge zh", "9876543456","pasha@mail.ru", false);
            Result result;
            result = instance.update(obj);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    @Test
    public void testUpdateProduct() throws Exception {
        try{
           System.out.println("Update Product");
            CsvAPI instance = new CsvAPI();
            Product obj= new Product(9876543L,"desk", 100 ,5);
            Result result;
            result = instance.update(obj);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    @Test
    public void testUpdatePayment() throws Exception {
        try{
           System.out.println("Update Payment");
            CsvAPI instance = new CsvAPI();
            Payment obj= new Payment(98766543L, "card", 19122016, 2);
            Result result;
            result = instance.update(obj);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
      @Test
    public void testUpdateOrder() throws Exception {
        try{
           System.out.println("Update Payment");
            CsvAPI instance = new CsvAPI();
            Payment payment = new Payment(1482176292007L, "card", 19122016, 2); 
            Order obj= new Order(1482176292007L, "12A765", 4236346435343L ,19122016,"sended", payment.getId(), 3, 4567876543L);
            Result result;
            result = instance.update(obj);
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
}
