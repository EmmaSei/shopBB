
package ru.sfedu.shop.dto;

import java.io.Serializable;
import org.simpleframework.xml.*;

/**
 *
 * @author Эмма
 */
public abstract class BaseDto implements Serializable{
    @Element
    private ClassType classType;
    
    @Element (name="id")
    private long id = 1l;
    
    public BaseDto(ClassType classType) throws InterruptedException {
        this.classType = classType;
        Thread.sleep(1);
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    public abstract String getValueByFieldName(String name) throws Exception;
}
