package ru.sfedu.shop.dao;

import static ru.sfedu.shop.Const.*;

import com.opencsv.*;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ru.sfedu.shop.dto.*;
import ru.sfedu.shop.model.*;

public class CsvAPI implements IGeneric{
    private static Logger log = Logger.getLogger(CsvAPI.class);

    @Override
    public Result insert(BaseDto obj) throws Exception{
        Result res= new Result();
        try{
            BeanToCsv beanToCsv = new BeanToCsv();
            List<BaseDto> list = addRecord(obj);
            CSVWriter csvw = new CSVWriter(new FileWriter(getFileName(obj.getClassType())), ',');
            beanToCsv.write(switchClass(obj.getClassType()), csvw, list);
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
    protected String getFileName(ClassType classType){
        String str;
        switch (classType){
            case DLV: str=DELIVERY_FILE_NAME; break;
            case CUS: str=CUSTOMER_FILE_NAME; break;
            case ORD: str=ORDER_FILE_NAME; break;
            case PAY: str=PAYMENT_FILE_NAME; break;
            case PRD: str=PRODUCT_FILE_NAME; break;
            default : str="error";log.error("it is impossible to determine the type of the class"); break; 
        }
        return str;
    }
    
    protected List<BaseDto> addRecord(BaseDto baseDto) throws Exception{
        CSVReader csvr = new CSVReader(new FileReader(getFileName(baseDto.getClassType())),',');
        CsvToBean csvToBean = new CsvToBean();
        try{
            FilterCSV filterCSV = new FilterCSV(switchClass(baseDto.getClassType()));
            List<BaseDto> list = csvToBean.parse(switchClass(baseDto.getClassType()), csvr, filterCSV);
            for(int i=0; i<list.size(); i++){
                if(list.get(i).equals(baseDto)){
                    throw new Exception();
                }
            }
            list.add(baseDto);
            csvr.close();
            return list;
        }
        catch(Exception e){
            csvr.close();
            throw e;
        }
    }
    public List<BaseDto> read(BaseDto baseDto) throws Exception{
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
    public Result getObjectByName(String name, ClassType classType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Delivery getDeliveryByOrderNumber(String number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment getOrderDetail(String orderNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomerActivity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPaymentProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result addPayment(Payment payment) throws Exception{
        Map <Long,Integer> products = payment.getProducts();
        ValueOfResult instance;
        for (Map.Entry<Long, Integer> entry : products.entrySet()) {
            instance=getObjectById(entry.getKey(), ClassType.PRD);
            isProductsExists(instance);
            isProductsCount(instance, (int)entry.getValue());
        }
        return insert(payment);
    }
    
    private boolean isProductsExists(ValueOfResult instance) throws Exception{
        boolean result = false;
        if(!instance.getStatus().equals(StatusType.GOOD.toString())){
                throw new Exception("Products not exist");
        }else{
            result = true;
        }
        return result;
    }
    
    private boolean isProductsCount(ValueOfResult instance, int count) throws Exception{
        boolean result = false;
        Product product = (Product) instance.getValue().get(0);
        if(product.getCount()<count){
                throw new Exception("Products count is few");
        }else{
            result = true;
        }
        return result;
    }

}
