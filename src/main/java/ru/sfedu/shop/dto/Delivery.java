package ru.sfedu.shop.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Delivery extends BaseDto{
    
    @Element
    private String method;
    
    @Element
    private float price;
    
    
    public Delivery() throws InterruptedException {
        super(ClassType.DLV);
    }

    public Delivery(long id, String method, float price) throws InterruptedException {
        super(ClassType.DLV);
        setId(id);
        this.method = method;
        this.price = price;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Delivery other = (Delivery) obj;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Delivery{" + "id=" + getId() + ", method=" + method + ", price=" + price + '}';
    }

    @Override
    public String getValueByFieldName(String name) throws Exception{
        String value;
        switch(name){
            case "id" : value = Long.toString(getId()); break;
            case "method"  : value = method; break;
            case "price"  : value = Float.toString(price); break;
            default : throw new Exception("field is not right");
        }
        return value;
    }    
    
}
