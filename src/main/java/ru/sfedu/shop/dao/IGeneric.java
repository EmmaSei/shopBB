package ru.sfedu.shop.dao;

import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.dto.Customer;
import ru.sfedu.shop.dto.Delivery;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.dto.Product;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.ValueOfResult;

/**
 *
 * @author Эмма
 */
public interface IGeneric {
    public Result insert(BaseDto baseDto)  throws Exception;
    public Result update(BaseDto baseDto)  throws Exception;
    public Result delete(BaseDto baseDto)  throws Exception;
    public Result select(ClassType classType)  throws Exception;
    
    public Result getObjectById(long id,ClassType classType)throws Exception;
    public Result getObjectByName(String name, ClassType classType);
    public Delivery getDeliveryByOrderNumber(String number);
    public Payment  getOrderDetail(String orderNumber);
    public void getCustomerActivity();
    public void getPaymentProduct();    
    
    public Result addPayment(Payment payment) throws Exception;
    
    
}
