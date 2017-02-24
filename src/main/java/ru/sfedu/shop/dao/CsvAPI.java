package ru.sfedu.shop.dao;

import static ru.sfedu.shop.Const.*;

import com.opencsv.*;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import ru.sfedu.shop.utils.FilterCSV;

import ru.sfedu.shop.dto.*;
import ru.sfedu.shop.model.*;
import static ru.sfedu.shop.utils.ConfigurationUtil.getConfigurationEntry;

public class CsvAPI implements IGeneric{
    private static Logger log = Logger.getLogger(CsvAPI.class);

    @Override
    public Result insert(ArrayList<BaseDto> obj) throws Exception{
        Result res= new Result();
        try{
            BeanToCsv beanToCsv = new BeanToCsv();
            List<BaseDto> list = addRecord(obj);
            CSVWriter csvw = new CSVWriter(new FileWriter(getFileName(obj.get(0).getClassType())), ',');
            beanToCsv.write(switchClass(obj.get(0).getClassType()), csvw, list);
            csvw.close();
            res.setStatus(StatusType.GOOD.toString());
            res.setErrMsg("cool!!!!!");
        }
        catch(Exception e){
            res.setStatus(StatusType.ERROR.toString());
            res.setErrMsg(e.getMessage());
        }
        return res;
    }
    
    @Override
    public Result update(BaseDto baseDto) throws Exception {
        Result res= new Result();
        try{
            BeanToCsv beanToCsv = new BeanToCsv();
            List<BaseDto> list = read(baseDto);
            CSVWriter csvw = new CSVWriter(new FileWriter(getFileName(baseDto.getClassType())), ',');
            beanToCsv.write(switchClass(baseDto.getClassType()), csvw, list);
            csvw.close();
            res.setStatus(StatusType.GOOD.toString());
            res.setErrMsg("cool!!!!!");
        }
        catch(Exception e){
            res.setStatus(StatusType.ERROR.toString());
            res.setErrMsg(e.getMessage());
        }
        return res;
    }

    @Override
    public Result delete(BaseDto baseDto) throws Exception {
        Result res= new Result();
        try{
            BeanToCsv beanToCsv = new BeanToCsv();
            List<BaseDto> list = read(baseDto);
            for(int i=0; i<list.size(); i++){
                if(list.get(i).equals(baseDto)){
                    list.remove(i);
                }
            }
            CSVWriter csvw = new CSVWriter(new FileWriter(getFileName(baseDto.getClassType())), ',');
            beanToCsv.write(switchClass(baseDto.getClassType()), csvw, list);
            csvw.close();
            res.setStatus(StatusType.GOOD.toString());
            res.setErrMsg("cool!!!!!");
        }
        catch(Exception e){
            res.setStatus(StatusType.ERROR.toString());
            res.setErrMsg(e.getMessage());
        }
        return res;
    }

    @Override
    public ValueOfResult select(ClassType classType) throws Exception {
        return select(classType, null, null);
    }
    
    public ValueOfResult select(ClassType classType, String arg, String value) throws Exception {
        ValueOfResult result=new ValueOfResult();
        CSVReader csvr = new CSVReader(new FileReader(getFileName(classType)),',');
        try{
            CsvToBean csvToBean= new CsvToBean();
            FilterCSV filter = new FilterCSV(switchClass(classType), arg, value);
            List<BaseDto> list = csvToBean.parse(switchClass(classType), csvr, filter);
            result.setValue(list);
            csvr.close();
            result.setStatus(StatusType.GOOD.toString());
        }
        catch(Exception e){
            csvr.close();
            result.setStatus(StatusType.ERROR.toString());
            result.setErrMsg(e.getMessage());
            log.error(e.getMessage());
            throw e;
        }
        return result;
    }
    protected String getFileName(ClassType classType) throws IOException{
        String str=getConfigurationEntry(PATH_CSV_STORE);
        str+=classType.toString()+".csv";
        return str;
    }
    
    protected List<BaseDto> addRecord(ArrayList<BaseDto> baseDto) throws Exception{
        CSVReader csvr = new CSVReader(new FileReader(getFileName(baseDto.get(0).getClassType())),',');
        CsvToBean csvToBean = new CsvToBean();
        try{
            FilterCSV filterCSV = new FilterCSV(switchClass(baseDto.get(0).getClassType()));
            List<BaseDto> list = csvToBean.parse(switchClass(baseDto.get(0).getClassType()), csvr, filterCSV);
            for(int i=0; i<list.size(); i++){
                for (int j = 0; j < baseDto.size(); j++) {
                    if(list.get(i).equals(baseDto.get(j))){
                        throw new Exception();
                    }
                }
            }
            list.addAll(baseDto);
            csvr.close();
            return list;
        }
        catch(Exception e){
            csvr.close();
            throw e;
        }
    }
    protected List<BaseDto> read(BaseDto baseDto) throws Exception{
        CSVReader csvr = new CSVReader(new FileReader(getFileName(baseDto.getClassType())),',');
        CsvToBean csvToBean = new CsvToBean();
        try{
            FilterCSV filterCSV = new FilterCSV(switchClass(baseDto.getClassType()));
            List<BaseDto> list = csvToBean.parse(switchClass(baseDto.getClassType()), csvr, filterCSV);
            for(int i=0; i<list.size(); i++){
                if(list.get(i).getId()==baseDto.getId()){
                    list.remove(i);
                    list.add(baseDto);
                }
            }
            csvr.close();
            return list;
        }
        catch(Exception e){
            csvr.close();
            throw e;
        }
    }
    protected ColumnPositionMappingStrategy switchClass(ClassType classType){
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy(); 
        switch (classType){
            case DLV: strategy.setType(Delivery.class); break;
            case CUS: strategy.setType(Customer.class); break;
            case ORD: strategy.setType(Order.class); break;
            case PAY: strategy.setType(Payment.class); break;
            case PRD: strategy.setType(Product.class); break;
            default : log.error("it is impossible to determine the type of the class"); break; 
        }
        strategy.setColumnMapping(classType.getDescription());
        return strategy;
    }
    
    @Override
    public ValueOfResult getObjectById(long id, ClassType classType) throws Exception{
        return select(classType, "id", Long.toString(id));
    }

    @Override
    public ValueOfResult getDeliveryByOrderNumber(String number) {
        ValueOfResult result= new ValueOfResult();
        Order order;
        try {
            order = (Order)select(ClassType.ORD, "number", number).getValue().get(0);
            result.setValue(select(ClassType.DLV, "id", Long.toString(order.getDelivery())).getValue());
            result.setStatus(StatusType.GOOD.toString());
        } catch (Exception ex) {
            log.error(ex);
            result.setStatus(StatusType.ERROR.toString());
            result.setErrMsg(ex.getMessage());   
        }
        return result;
        
    }

    @Override
    public ValueOfResult getOrderDetail(String orderNumber) {
        CsvAPI csvAPI = new CsvAPI();
        ValueOfResult result = new ValueOfResult();
        try {
            result=csvAPI.select(ClassType.ORD, "number", orderNumber);
            result.setStatus(StatusType.GOOD.toString());
        } catch (Exception ex) {
            log.error(ex);
            result.setStatus(StatusType.ERROR.toString());
            result.setErrMsg(ex.getMessage());
        }
        return result;
    }

    @Override
    public ValueOfResult getCustomerActivity(long customerId) {
        ValueOfResult result = new ValueOfResult();
        try {
            result=select(ClassType.ORD, "customer", Long.toString(customerId));
            result.setStatus(StatusType.GOOD.toString());
        } catch (Exception ex) {
            log.error(ex);
            result.setStatus(StatusType.ERROR.toString());
            result.setErrMsg(ex.getMessage());        
        }
        return result;
    }
    
    public Result insert(Order order) throws Exception{
        ValueOfResult instance;
        instance=getObjectById(order.getCustomer(), ClassType.CUS);
        if (!isObjectExists(instance)) {instance.setStatus(StatusType.ERROR.toString()); return instance;}
        instance=getObjectById(order.getDelivery(), ClassType.DLV);
        if (!isObjectExists(instance)) {instance.setStatus(StatusType.ERROR.toString()); return instance;}
        instance=getObjectById(order.getPayment(), ClassType.PAY);
        if (!isObjectExists(instance)) {instance.setStatus(StatusType.ERROR.toString()); return instance;}
//        Map <Long,Integer> products = order.getProducts();
//        for (Map.Entry<Long, Integer> entry : products.entrySet()) {
//            instance=getObjectById(entry.getKey(), ClassType.PRD);
//            isObjectExists(instance);
//            isProductsCount(instance, (int)entry.getValue());
//        }
        ArrayList<BaseDto> list = new ArrayList<>(1);
        list.add(order);
        return insert(list);
    }
    
    private boolean isObjectExists(ValueOfResult instance) throws Exception{
        boolean result = false;
        if(!instance.getStatus().equals(StatusType.GOOD.toString())){
                result = false;
        }else{
            result = true;
        }
        return result;
    }
    
    private boolean isProductsCount(ValueOfResult instance, int count) throws Exception{
        boolean result = false;
        CsvAPI csvAPI = new CsvAPI();
        Product product = (Product) instance.getValue().get(0);
        if(product.getCount()<count){
                throw new Exception("Products count is few");
        }else {
            product.setCount(product.getCount()-count);
            csvAPI.update(product);
            result = true;
        }
        return result;
    }

}
