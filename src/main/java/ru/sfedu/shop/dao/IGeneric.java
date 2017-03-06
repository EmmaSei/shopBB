package ru.sfedu.shop.dao;

import java.util.ArrayList;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.dto.Payment;
import ru.sfedu.shop.model.Result;

/**
 *
 * @author Эмма
 */
public interface IGeneric {
    public Result insert(ArrayList<BaseDto> baseDto)  throws Exception;
    public Result update(BaseDto baseDto)  throws Exception;
    public Result delete(BaseDto baseDto)  throws Exception;
    public Result select(ClassType classType)  throws Exception;
    public Result select(ClassType classType, String arg, String value) throws Exception;
    
}
