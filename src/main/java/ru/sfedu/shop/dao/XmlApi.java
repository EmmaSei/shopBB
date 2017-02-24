package ru.sfedu.shop.dao;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import static ru.sfedu.shop.Const.PATH_XML_STORE;
import ru.sfedu.shop.Main;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.dto.ContainerPayment;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;
import ru.sfedu.shop.model.ValueOfResult;
import static ru.sfedu.shop.utils.ConfigurationUtil.getConfigurationEntry;

public class XmlApi implements IGeneric{
    private static final Logger log = Logger.getLogger(Main.class);
    
    @Override
    public ValueOfResult insert(ArrayList<BaseDto> list) throws Exception {
        if (list.isEmpty()) {
           throw new Exception("list is empty");
        }
        File file = new File(getFileName(list.get(0).getClassType()));
        Serializer serializer = new Persister();
        ValueOfResult res = new ValueOfResult();
        ContainerPayment container = new ContainerPayment();
        list.addAll(select(list.get(0).getClassType()).getValue());
        container.setList(list);
        try{
            
            serializer.write(container, file);
            res.setStatus(StatusType.GOOD.toString());
            res.setErrMsg("cool!!!!!");
        } 
        catch (Exception e) {
            res.setStatus(StatusType.ERROR.toString());
            res.setErrMsg(e.getMessage());
        }  
        return res;
    }
    
    public static String getFileName(ClassType classType) throws IOException{
        String str=getConfigurationEntry(PATH_XML_STORE);
        str+=classType.toString()+".xml";
        return str;
    }

    @Override
    public Result update(BaseDto baseDto) throws Exception {
        Result result = new Result();
        try{
            result=delete(baseDto);
            if(!result.getStatus().equals(StatusType.GOOD.toString())){
                throw new Exception(result.getErrMsg());
            }
            ArrayList<BaseDto> list = new ArrayList<>(1);
            list.add(baseDto);
            result=insert(list);
            if(!result.getStatus().equals(StatusType.GOOD.toString())){
                throw new Exception(result.getErrMsg());
            }
        }catch(Exception e){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrMsg(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public Result delete(BaseDto baseDto) throws Exception {
        Result result = new Result();
        try {
            Serializer serializer = new Persister();
            ContainerPayment container = new ContainerPayment();
            ArrayList<BaseDto> list;
            ValueOfResult rv = select(baseDto.getClassType());
            list = (ArrayList<BaseDto>) rv.getValue();
            if(list.isEmpty())
                throw new Exception("File is empty");
            list.remove(select(baseDto.getClassType(), "id", Long.toString(baseDto.getId())).getValue().get(0));
            container.setList(list);
            File file = new File(getFileName(list.get(0).getClassType()));
            serializer.write(container, file);
            result.setStatus(StatusType.GOOD.toString());
        } catch (Exception e) {
            result.setStatus(StatusType.ERROR.toString());
            result.setErrMsg("Error : " + e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public ValueOfResult select(ClassType classType) throws Exception {
        return select(classType, null, null);
    }

    @Override
    public ValueOfResult select(ClassType classType, String arg, String value) throws Exception {
        ValueOfResult result=new ValueOfResult();
        Serializer serializer = new Persister();
        ArrayList<BaseDto> list;
        File source = new File(getFileName(classType));
        ContainerPayment container;
        try{
            container=serializer.read(ContainerPayment.class, source);
            list = container.getList();
            if ((arg != null) && (value != null)) {
                for (int i = 0; i < list.size(); i++) {
                    if(!list.get(i).getValueByFieldName(arg).equals(value)){
                        list.remove(i--);
                    }
                }
            }
            result.setValue(list);
            result.setStatus(StatusType.GOOD.toString());
        }
        catch(Exception e){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrMsg(e.getMessage());
            log.error(e.getMessage());
            throw e;
        }
        return result;
    }
    
    @Override
    public Result getObjectById(long id, ClassType classType) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result getDeliveryByOrderNumber(String number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result getOrderDetail(String orderNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result getCustomerActivity(long customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
