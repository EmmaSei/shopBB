package ru.sfedu.shop.dto;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "root")
public class Container {
    
    @ElementList (required = false,name="container")
    ArrayList <BaseDto> list;

    public Container() {
    }
    
    public ArrayList<BaseDto> getList() {
        return list;
    }

    public void setList(ArrayList<BaseDto> list) {
        this.list = list;
    }
    
}
